package com.ibm.restaurant.domain;


public interface IOrdersRepository {

    void createOrder(Orders orders);

    Orders getOrdersById(Long orderId);
}
