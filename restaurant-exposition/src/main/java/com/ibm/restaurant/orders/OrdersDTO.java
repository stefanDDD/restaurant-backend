package com.ibm.restaurant.orders;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrdersDTO {

    @JsonProperty
    public String orderClient;

    @JsonProperty
    private String orderTime;

    @JsonProperty
    private String orderStatus;

    @JsonProperty
    private String orderList;
}
