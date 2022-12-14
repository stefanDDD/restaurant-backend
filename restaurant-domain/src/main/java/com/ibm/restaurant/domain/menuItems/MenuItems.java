package com.ibm.restaurant.domain.menuItems;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name = "MENU_ITEMS")
public class MenuItems {
//DONE HERE
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MENU_ITEM_ID")
    private Long menuItemId;

    @Column(name = "ITEM_NAME")
    private String menuItemName;

    @Column(name = "DESCRIPTION")
    private String menuItemDescription;

    @Column(name = "PRICE")
    private Double menuItemPrice;

    public MenuItems(){

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

    public Double getMenuItemPrice() {
        return menuItemPrice;
    }

    public void setMenuItemPrice(Double menuItemPrice) {
        this.menuItemPrice = menuItemPrice;
    }

    public MenuItems(String menuItemName, Double menuItemPrice, String menuItemDescription) {
        this.menuItemName = menuItemName;
        this.menuItemPrice = menuItemPrice;
        this.menuItemDescription = menuItemDescription;
    }

}
