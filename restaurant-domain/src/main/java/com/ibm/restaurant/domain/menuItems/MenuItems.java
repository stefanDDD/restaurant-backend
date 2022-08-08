package com.ibm.restaurant.domain.menuItems;

import com.ibm.restaurant.domain.orders.Orders;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@javax.persistence.Table(name = "MENU_ITEMS")
public class MenuItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MENU_ITEM_ID")
    private Long menuItemId;

    @Column(name = "ITEM_NAME")
    private String menuItemName;

    @Column(name = "DESCRIPTION")
    private String menuItemDescription;

    @Column(name = "PRICE")
    private Float menuItemPrice;


    public Float ordersPrice;

    public Float getOrdersPrice() {
        return ordersPrice;
    }

    public void setOrdersPrice(Float ordersPrice) {
        this.ordersPrice = ordersPrice;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ORDER_ID", nullable = false)
    private com.ibm.restaurant.domain.orders.Orders orders;

    public com.ibm.restaurant.domain.orders.Orders getOrders(){
        return orders;
    }

    public void setOrders(com.ibm.restaurant.domain.orders.Orders orders){
        this.orders = orders;
    }

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
