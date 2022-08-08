package com.ibm.restaurant.orders;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ibm.restaurant.domain.orders.Orders;
import com.ibm.restaurant.menuItems.MenuItemsDTO;

import java.util.List;
import java.util.Set;

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
    public Double ordersPrice;

    @JsonProperty
    public long ordersId;

    public Set<MenuItemsDTO> menuItemsDTO;

    public List<String> ordersList;




}
