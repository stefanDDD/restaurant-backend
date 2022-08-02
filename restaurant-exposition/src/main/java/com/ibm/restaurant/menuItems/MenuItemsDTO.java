package com.ibm.restaurant.menuItems;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MenuItemsDTO {

    @JsonProperty
    public String menuItemsName;

    @JsonProperty
    public String menuItemsDescription;

    @JsonProperty
    public Float menuItemsPrice;

    @JsonProperty
    public Long menuItemsId;
}
