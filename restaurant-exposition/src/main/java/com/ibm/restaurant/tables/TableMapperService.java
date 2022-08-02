package com.ibm.restaurant.tables;

import com.ibm.restaurant.domain.tables.Tables;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class TableMapperService {

    public Tables mapToDomain(TableDto dto) {
        Tables table = new Tables();
        table.setStatus(dto.status);
        table.setCapacity(dto.capacity);
        return table;
    }

    public TableDto mapFromDomain(Tables table){
        TableDto dto = new TableDto();
        dto.capacity = table.getCapacity();
        dto.status = table.getStatus();
        dto.id = table.getId();
        return dto;
    }

    public HashSet<TableDto> mapFromDomain(HashSet<Tables> tableList)
    {
        HashSet <TableDto> listAux = new HashSet<>();
        for(Tables table : tableList)
        {
            listAux.add(mapFromDomain(table));

        }
        return listAux;
    }

}
