package com.ibm.restaurant.reservation;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ibm.restaurant.tables.TableDto;

public class ReservationDTO {

    @JsonProperty
    public Long reservationId;
    @JsonProperty
    public Long tableId;
    @JsonProperty
    public TableDto tableDto;

    @JsonProperty
    public String clientName;
}
