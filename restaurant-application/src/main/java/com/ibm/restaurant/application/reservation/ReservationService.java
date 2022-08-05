package com.ibm.restaurant.application.reservation;

import com.ibm.restaurant.domain.reservations.Reservation;
import com.ibm.restaurant.domain.reservations.IReservationRepository;
import com.ibm.restaurant.domain.tables.ITableRepository;
import com.ibm.restaurant.domain.tables.Tables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ITableRepository tableRepository;
    @Autowired
    private IReservationRepository reservationRepository;


    public void createReservation(Reservation reservation, Long tableId) {
        Tables table = tableRepository.getTableById(tableId);
        reservation.setTable(table);
        reservationRepository.createReservation(reservation);
    }

    public List<Reservation> findAllByClientName(String clientName) {
        return reservationRepository.findAllByClientName(clientName);
    }
}
