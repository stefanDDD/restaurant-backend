package com.ibm.restaurant.orders;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PlaceOrderDTO {
    @JsonProperty
    public Long tableId;

    @JsonProperty
    public List<Long> menuItems;

}