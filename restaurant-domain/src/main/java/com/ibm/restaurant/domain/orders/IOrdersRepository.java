package com.ibm.restaurant.domain.orders;


import com.ibm.restaurant.domain.menuItems.MenuItems;

import javax.persistence.criteria.Order;
import java.util.HashSet;
import java.util.List;

public interface IOrdersRepository {

    Orders createOrder(Orders orders);

    void updateOrder(Orders orders);

    void cancelOrder(Orders orders);

    void readyToBeDeliveredOrder(Orders orders);

    void deliveredOrder(Orders orders);

    HashSet<Orders> getOrdersList();

    Orders getOrderById(Long ordersId);




}
