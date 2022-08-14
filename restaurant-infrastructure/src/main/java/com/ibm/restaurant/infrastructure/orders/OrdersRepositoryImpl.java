package com.ibm.restaurant.infrastructure.orders;

import com.ibm.restaurant.domain.menuItems.MenuItems;
import com.ibm.restaurant.domain.orders.IOrdersRepository;
import com.ibm.restaurant.domain.orders.Orders;
import com.ibm.restaurant.domain.reservations.Reservation;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.Order;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class OrdersRepositoryImpl implements IOrdersRepository {

    @Autowired
    private IOrdersRepositorySdj iOrdersRepositorySdj;

    @Override
    public Orders createOrder(Orders orders) {
        return iOrdersRepositorySdj.save(orders);
    }

    @Override
    public HashSet<Orders> getOrdersList() {
        return new HashSet<>(iOrdersRepositorySdj.findAll());
    }


    @Override
    public Orders updateOrder(Orders orders) {

        return iOrdersRepositorySdj.save(orders);
    }

    @Override
    public Orders cancelOrder(Long ordersId, Order orderStatus) {
        List<Orders> orders = new ArrayList<>();
        return null;
    }

    @Override
    public Orders getOrderById(Long ordersId){
        return iOrdersRepositorySdj.findById(ordersId).orElseThrow(null);
    }


}
