package com.ibm.restaurant.orders;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ibm.restaurant.domain.menuItems.MenuItems;
import com.ibm.restaurant.domain.orders.OrderStatus;
import com.ibm.restaurant.domain.orders.Orders;
import com.ibm.restaurant.menuItems.MenuItemsDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_NULL)
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
    public List<MenuItemsDTO> menuItemsDTO;

    @JsonProperty
    public Double ordersPrice;



}
