package com.ibm.restaurant.domain;


import java.util.Objects;

public class Orders {

    private final Long orderId;
    private String orderClient;
    private String orderTime;
    private String orderStatus;
    private String orderList;

    public Orders(Long orderId, String orderList) {
        this.orderId = orderId;
    }

    public Long getOrderId() {
        return orderId;
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
        this.orderTime = orderTime;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
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
        return "Order{ id= "+ orderId+", order list= "+orderList+", order time= "+orderTime+", order status= "+orderStatus+", order client= "+orderClient+" }";
    }

}
