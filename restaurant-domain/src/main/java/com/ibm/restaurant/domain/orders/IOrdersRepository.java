package com.ibm.restaurant.domain.orders;


import com.ibm.restaurant.domain.menuItems.MenuItems;

import javax.persistence.criteria.Order;
import java.util.HashSet;
import java.util.List;

public interface IOrdersRepository {

    Orders createOrder(final Orders orders);

    Orders updateOrder(final Orders orders);

    Orders cancelOrder(Long ordersId, Order orderStatus);

    HashSet<Orders> getOrdersList();

    Orders getOrderById(final Long ordersId);




}
