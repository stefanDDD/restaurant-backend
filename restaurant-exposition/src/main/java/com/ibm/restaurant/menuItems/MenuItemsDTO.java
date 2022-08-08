package com.ibm.restaurant.menuItems;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ibm.restaurant.orders.OrdersDTO;

import java.util.Set;

public class MenuItemsDTO {

    @JsonProperty
    public String menuItemsName;

    @JsonProperty
    public String menuItemsDescription;

    @JsonProperty
    public Float menuItemsPrice;

    @JsonProperty
    public Long menuItemsId;

    @JsonProperty
    public Long ordersId;

}
