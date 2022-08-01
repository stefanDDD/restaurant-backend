package com.ibm.restaurant.orders;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ibm.restaurant.domain.Orders;

public class OrdersDTO {

    @JsonProperty
    public String orderTime;

    public enum status{
        IN_PROGRESS,
        IN_DELIVERY,
        DELIVERED,
        CANCELED
    }
    @JsonProperty
    public Orders.status orderStatus;

    @JsonProperty
    public String orderList;

    @JsonProperty
    public long ordersId;

}
