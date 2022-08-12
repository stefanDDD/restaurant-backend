package com.ibm.restaurant.tables;

import com.ibm.restaurant.domain.exception.BusinessException;
import com.ibm.restaurant.domain.tables.TableStatus;
import com.ibm.restaurant.domain.tables.Tables;
import com.ibm.restaurant.reservation.ReservationMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.stream.Collectors;

@Service
public class TableMapperService {
    @Autowired
    private ReservationMapperService reservationMapperService;

    public Tables mapToDomain(TableDto dto) {
        Tables table = new Tables();
        try{
            TableStatus tableStatus = TableStatus.valueOf(dto.status);
            table.setStatus(dto.status);

        }
        catch (IllegalArgumentException ex){
            throw new BusinessException("Table status is incorrect!", "BAD_REQUEST");
        }
        table.setCapacity(dto.capacity);
        return table;
    }

    public TableDto mapFromDomain(Tables table){
        TableDto dto = new TableDto();
        dto.capacity = table.getCapacity();
        dto.status = table.getStatus();
        dto.id = table.getId();
        dto.reservationDto = table.getReservations().stream().map(reservationMapperService::mapFromDomain).collect(Collectors.toSet());
        return dto;
    }

    public HashSet<TableDto> mapFromDomain(HashSet<Tables> tableList) {
        HashSet<TableDto> listAux = new HashSet<>();
        for (Tables table : tableList) {
            listAux.add(mapFromDomain(table));

        }
        return listAux;
    }
}
