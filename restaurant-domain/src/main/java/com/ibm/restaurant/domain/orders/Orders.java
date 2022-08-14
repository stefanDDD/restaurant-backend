package com.ibm.restaurant.domain.orders;



import com.ibm.restaurant.domain.menuItems.MenuItems;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.*;

@Entity
@Table(name = "ONLINE_ORDERS")
public class Orders {

    public Orders(){

    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    private Long orderId;
    @Column(name = "CUSTOMER_ID")
    private String orderClient;

    public Orders(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Column(name = "ORDER_DATE")
    private String orderTime;
    @Column(name = "DELIVERY_STATUS")
    public OrderStatus orderStatus;

    public Double orderPrice;

    public Double getOrderPrice() {

        return orderPrice;
    }

    public void setOrderPrice(Double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Set<MenuItems> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(Set<MenuItems> menuItems) {
        this.menuItems = menuItems;
    }

    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "CUSTOMER_ID", updatable = false, insertable = false)
    private com.ibm.restaurant.domain.customer.Customer customer;
    @ManyToMany
    @JoinTable(
            name = "ONLINE_ORDERS_MENU_ITEMS",
            joinColumns = @JoinColumn(name = "ORDER_ID"),
            inverseJoinColumns = @JoinColumn(name = "MENU_ITEM_ID"))
    private Set<MenuItems> menuItems = new HashSet<>();

    public void addMenuItem(MenuItems menuItems) {
        this.menuItems.add(menuItems);
    }

    public Orders(Long orderId, String orderList) {
        this.orderId = orderId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderClient() {
        return orderClient;
    }

    public void setOrderClient(String orderClient) {
        this.orderClient = orderClient;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        Calendar date1 = Calendar.getInstance();
        orderTime = String.valueOf(date1.getTime());
        this.orderTime = orderTime;
    }

    public com.ibm.restaurant.domain.customer.Customer getCustomer(){
        return customer;
    }

    public void setCustomer(com.ibm.restaurant.domain.customer.Customer customer) {
        this.customer = customer;
    }

}
