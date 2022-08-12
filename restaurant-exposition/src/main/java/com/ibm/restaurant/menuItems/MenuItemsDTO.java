package com.ibm.restaurant.menuItems;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;


public class MenuItemsDTO {
//This class is done
    @JsonProperty
    public String menuItemsName;

    @JsonProperty
    public String menuItemsDescription;

    @JsonProperty
    public BigDecimal menuItemsPrice;

    @JsonProperty
    public Long menuItemsId;



}
