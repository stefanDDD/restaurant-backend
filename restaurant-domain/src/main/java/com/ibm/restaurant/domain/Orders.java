package com.ibm.restaurant.domain;


import sun.util.calendar.BaseCalendar;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class Orders {

    private Long orderId;
    private String orderClient;
    private String orderTime;

    public status orderStatus;
    public enum status{
        IN_PROGRESS,
        IN_DELIVERY,
        DELIVERED,
        CANCELED
    }
    private String orderList;

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

    public String getOrderList() {
        return orderList;
    }

    public void setOrderList(String orderList) {
        this.orderList = orderList;
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
               // ", order list= "+orderList+'\''+
               // ", order time= "+orderTime+'\''+
               // ", order status= "+orderStatus+'\''+
               // ", order client= "+orderClient+'\''+
                " }";
    }

}
