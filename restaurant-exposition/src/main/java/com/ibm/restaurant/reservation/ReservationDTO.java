package com.ibm.restaurant.reservation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ibm.restaurant.tables.TableDto;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReservationDTO {

    @JsonProperty
    public Long reservationId;
    @JsonProperty
    public Long tableId;
    @JsonProperty
    public TableDto tableDto;

    @JsonProperty
    public String clientName;
    @JsonProperty
    public Integer personNo;
}
