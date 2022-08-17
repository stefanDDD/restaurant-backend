package com.ibm.restaurant.menuItems;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MenuItemsDTO {
//This class is done
    @JsonProperty
    public String menuItemsName;

    @JsonProperty
    public String menuItemsDescription;

    @JsonProperty
    public Double menuItemsPrice;

    @JsonProperty
    public Long menuItemsId;



}
