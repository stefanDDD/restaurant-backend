package com.ibm.restaurant.domain;


import javax.persistence.criteria.Order;
import java.util.HashSet;

public interface IOrdersRepository {

    void createOrder(Orders orders);

    Orders getOrdersById(Long orderId);

    HashSet<Orders> getOrdersList();

    Orders cancelOrder(Long ordersId, Order orderStatus);

}
