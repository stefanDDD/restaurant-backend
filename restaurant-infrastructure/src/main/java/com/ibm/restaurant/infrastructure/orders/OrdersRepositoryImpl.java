package com.ibm.restaurant.infrastructure.orders;

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
    public void createOrder(Orders orders) {
        iOrdersRepositorySdj.save(orders);
    }

    @Override
    public Orders getOrdersById(Long orderId) {
        return iOrdersRepositorySdj.findById(orderId).orElse(null);
    }

    @Override
    public Orders getOrdersPrice(Double ordersPrice) {
        return null;
    }

    @Override
    public HashSet<Orders> getOrdersList() {
        return new HashSet<>(iOrdersRepositorySdj.findAll());
    }

    @Override
    public void cancelOrder(Orders orders) {

        iOrdersRepositorySdj.save(orders);
    }


}
