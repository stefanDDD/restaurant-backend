package com.ibm.restaurant.application.reservations;

import com.ibm.restaurant.domain.Clients;
import com.ibm.restaurant.domain.IOrdersRepository;
import com.ibm.restaurant.domain.ITableRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ReservationsService {
    @Autowired
    private ITableRepository iTableRepository;

    @Autowired
    private IOrdersRepository iOrdersRepository;

    public void createReservation(Clients clients){


    }


}
