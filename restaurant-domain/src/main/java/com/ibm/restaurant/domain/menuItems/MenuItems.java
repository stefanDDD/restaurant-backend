package com.ibm.restaurant.domain.menuItems;

import java.util.Objects;

public class MenuItems {

    private Long menuItemId;

    private String menuItemName;

    private String menuItemDescription;

    private Float menuItemPrice;

    public Long getMenuItemId() {
        return menuItemId;
    }

    public void setMenuItemId(Long menuItemId) {
        this.menuItemId = menuItemId;
    }

    public String getMenuItemName() {
        return menuItemName;
    }

    public void setMenuItemName(String menuItemName) {
        this.menuItemName = menuItemName;
    }

    public String getMenuItemDescription() {
        return menuItemDescription;
    }

    public void setMenuItemDescription(String menuItemDescription) {
        this.menuItemDescription = menuItemDescription;
    }

    public Float getMenuItemPrice() {
        return menuItemPrice;
    }

    public void setMenuItemPrice(Float menuItemPrice) {
        this.menuItemPrice = menuItemPrice;
    }

    @Override
    public boolean equals(Object menuItemsObject){
        if(this == menuItemsObject)
            return true;
        if(menuItemsObject == null || getClass()!=menuItemsObject.getClass());
        MenuItems menuItems =(MenuItems) menuItemsObject;
        return Objects.equals(menuItemId, menuItems.menuItemId);
    }

    @Override
    public int hashCode(){
        return Objects.hash(menuItemId);
    }
    @Override
    public String toString(){
        return "Menu Item{"+
                ", Menu Item name= "+menuItemName+'\''+
                ", Menu Item price= "+menuItemPrice+'\''+
                ", Menu Item description= "+menuItemDescription+'\''+
                " }";
    }
}
