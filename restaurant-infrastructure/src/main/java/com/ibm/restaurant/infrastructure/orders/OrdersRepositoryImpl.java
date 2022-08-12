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
    public Orders createOrder(Orders orders) {
        return iOrdersRepositorySdj.save(orders);
    }

    @Override
    public List<Orders> getOrdersList() {
        return iOrdersRepositorySdj.findAll();
    }

    @Override
    public Orders cancelOrder(Orders orders) {

        return iOrdersRepositorySdj.save(orders);
    }

    @Override
    public Orders updateOrders(Orders orders) {

        return iOrdersRepositorySdj.save(orders);
    }


}
