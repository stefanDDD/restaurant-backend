package com.ibm.restaurant.domain.orders;


import java.util.HashSet;


public interface IOrdersRepository {

    Orders createOrder(Orders orders);

    void updateOrder(Orders orders);

    void cancelOrder(Orders orders);

    void readyToBeDeliveredOrder(Orders orders);

    void deliveredOrder(Orders orders);

    HashSet<Orders> getOrdersList();

    Orders getOrderById(Long ordersId);

    Orders getOrderPrice(Long ordersId);




}
