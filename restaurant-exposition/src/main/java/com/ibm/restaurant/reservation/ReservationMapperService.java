package com.ibm.restaurant.reservation;

import com.ibm.restaurant.domain.reservations.Reservation;
import com.ibm.restaurant.domain.tables.Tables;
import com.ibm.restaurant.tables.TableDto;
import org.springframework.stereotype.Service;

@Service
public class ReservationMapperService {

    public Reservation mapToDomain(final ReservationDTO dto) {
        if (dto != null) {
            Reservation reservation = new Reservation();
            reservation.setClientName(dto.clientName);
            reservation.setPersonNo(dto.personNo);
            return reservation;
        }
        return null;
    }

    public ReservationDTO mapFromDomain(Reservation reservation) {
        if (reservation != null) {
            ReservationDTO dto = new ReservationDTO();
            dto.reservationId = reservation.getReservationId();
            dto.tableDto = mapTableFromDomain(reservation.getTable());
            dto.clientName = reservation.getClientName();
            dto.personNo = reservation.getPersonNo();
            return dto;
        }

        return null;
    }

    public TableDto mapTableFromDomain(Tables table) {
        TableDto dto = new TableDto();
        dto.capacity = table.getCapacity();
        dto.status = table.getStatus();
        return dto;
    }
}
