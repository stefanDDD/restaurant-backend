package com.ibm.restaurant.domain.orders;


import javax.persistence.criteria.Order;
import java.util.HashSet;

public interface IOrdersRepository {

    void createOrder(Orders orders);

    Orders getOrdersById(Long orderId);

    Orders getOrdersPrice(Double ordersPrice);

    HashSet<Orders> getOrdersList();

    Orders cancelOrder(Long ordersId, Order orderStatus);

}
