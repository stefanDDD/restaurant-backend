package com.ibm.restaurant.orders;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ibm.restaurant.domain.orders.OrderStatus;
import com.ibm.restaurant.domain.orders.Orders;
import com.ibm.restaurant.menuItems.MenuItemsDTO;

import java.util.List;
import java.util.Set;

public class OrdersDTO {

    @JsonProperty
    public String orderTime;

    @JsonProperty
    public OrderStatus orderStatus;

    @JsonProperty
    public long ordersId;

    @JsonProperty
    public long customerId;
    @JsonProperty
    public Set<MenuItemsDTO> menuItemsDTO;


}
