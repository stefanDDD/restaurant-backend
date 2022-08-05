package com.ibm.restaurant.tables;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ibm.restaurant.domain.reservations.Reservation;
import com.ibm.restaurant.reservation.ReservationDTO;

import java.util.Set;

public class TableDto {

    @JsonProperty
    public String capacity;
    @JsonProperty
    public String status;
    @JsonProperty
    public long id;
    @JsonProperty
    public Set<ReservationDTO> reservationDto;
}
