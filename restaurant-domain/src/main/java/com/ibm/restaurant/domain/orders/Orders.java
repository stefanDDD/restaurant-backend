package com.ibm.restaurant.domain.orders;



import com.ibm.restaurant.domain.menuItems.MenuItems;

import javax.persistence.*;
import java.awt.*;
import java.util.*;
import java.util.List;

@Entity
@javax.persistence.Table(name = "ONLINE_ORDERS")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    private Long orderId;
    @Column(name = "CUSTOMER_ID")
    private String orderClient;
    @Column(name = "ORDER_DATE")
    private String orderTime;
    @Column(name = "DELIVERY_STATUS")
    public status orderStatus;

    public String orderList;

    public String getOrderList() {
        return orderList;
    }

    public void setOrderList(String orderList) {
        this.orderList = orderList;
    }

    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private final List<MenuItems> menuItems = new ArrayList<>();

    public List<MenuItems> getMenuItems(){
        return menuItems;
    }


    public Orders() {

    }

    public enum status{
        IN_PROGRESS,
        IN_DELIVERY,
        DELIVERED,
        CANCELED
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

    public status getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(status orderStatus) {
        this.orderStatus = orderStatus;
    }


    @Override
    public boolean equals(Object orderObject){
        if(this == orderObject)
            return true;
        if(orderObject == null || getClass()!=orderObject.getClass())
            return false;
        Orders orders = (Orders) orderObject;
        return Objects.equals(orderId, orders.orderId);
    }
    @Override
    public int hashCode(){return Objects.hash(orderId);}
    @Override
    public String toString(){
        return "Order{ " +
                "id= "+ orderId+
                 ", order time= "+orderTime+'\''+
                 ", order status= "+orderStatus+'\''+
                " }";
    }



}
