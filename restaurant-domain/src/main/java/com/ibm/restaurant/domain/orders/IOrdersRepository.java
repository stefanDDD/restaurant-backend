package com.ibm.restaurant.domain.orders;


import javax.persistence.criteria.Order;
import java.util.HashSet;
import java.util.List;

public interface IOrdersRepository {

    Orders createOrder(final Orders orders);

    Orders updateOrders(final Orders orders);

    Orders cancelOrder(final Orders orderStatus);

    List<Orders> getOrdersList();



}
