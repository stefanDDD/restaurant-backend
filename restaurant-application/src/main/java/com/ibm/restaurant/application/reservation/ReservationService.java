package com.ibm.restaurant.application.reservation;

import com.ibm.restaurant.domain.exception.BusinessException;
import com.ibm.restaurant.domain.exception.NotFoundException;
import com.ibm.restaurant.domain.reservations.Reservation;
import com.ibm.restaurant.domain.reservations.IReservationRepository;
import com.ibm.restaurant.domain.tables.ITableRepository;
import com.ibm.restaurant.domain.tables.TableStatus;
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
        if(table == null){
            throw new NotFoundException(String.format("Table with id %s does not exist in the system!", tableId));
        }
        else if (Integer.parseInt(table.getCapacity()) >= reservation.getPersonNo()) {
        reservation.setTable(table);
        reservationRepository.createReservation(reservation);
        } else {
            String messsage = "Table capacity is lower than person number!";
            String code = "BAD_REQUEST";
            throw new BusinessException(messsage, code);
        }
    }

    public List<Reservation> findAllByClientName(String clientName) {
        return reservationRepository.findAllByClientName(clientName);
    }

    public Reservation getReservationById(Long reservationId){
        return reservationRepository.getReservationById(reservationId);
    }



    public Reservation updateReservation(Reservation reservation){
        Reservation reservationFromDB = getReservationById(reservation.getReservationId());
            reservationFromDB.setClientName(reservation.getClientName());
            reservationFromDB.setTable(reservation.getTable());
            reservationFromDB.setPersonNo(reservation.getPersonNo());
            return reservationRepository.updateReservation(reservationFromDB);

    }


}
