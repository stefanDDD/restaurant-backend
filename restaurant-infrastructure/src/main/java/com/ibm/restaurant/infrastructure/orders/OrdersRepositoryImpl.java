package com.ibm.restaurant.infrastructure.orders;

import com.ibm.restaurant.domain.orders.IOrdersRepository;
import com.ibm.restaurant.domain.orders.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

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
        return new HashSet<>((Collection) iOrdersRepositorySdj.findAll());
    }


    @Override
    public void updateOrder(Orders orders) {

        iOrdersRepositorySdj.save(orders);
    }


    @Override
    public void cancelOrder(Orders orders) {
        iOrdersRepositorySdj.save(orders);

    }

    @Override
    public void readyToBeDeliveredOrder(Orders orders) {
        iOrdersRepositorySdj.save(orders);

    }

    @Override
    public void deliveredOrder(Orders orders) {
        iOrdersRepositorySdj.save(orders);
    }
    @Override
    public Orders getOrderPrice(Long ordersId){
        return iOrdersRepositorySdj.findById(ordersId).orElseThrow(null);
    }

    @Override
    public Orders getOrderById(Long ordersId){
        return iOrdersRepositorySdj.findById(ordersId).orElseThrow(null);
    }


}
