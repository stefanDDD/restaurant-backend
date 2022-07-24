package com.ibm.restaurant.orders;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ibm.restaurant.domain.Orders;

public class OrdersDTO {

    @JsonProperty
    public String orderClient;

    @JsonProperty
    public String orderTime;

    @JsonProperty
    public String orderStatus;

    @JsonProperty
    public String orderList;

}
