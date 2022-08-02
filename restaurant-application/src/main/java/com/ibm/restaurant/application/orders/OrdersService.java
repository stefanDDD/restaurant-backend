package com.ibm.restaurant.application.orders;

import com.ibm.restaurant.domain.IOrdersRepository;
import com.ibm.restaurant.domain.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;


@Service
public class OrdersService {

    @Autowired
    private IOrdersRepository iOrdersRepository;

    public void createOrders(Orders orders){
        long ordersId = getOrdersList().size()+1;
        orders.setOrderId(ordersId);
        orders.setOrderStatus(Orders.status.IN_PROGRESS);
        iOrdersRepository.createOrder(orders);
    }


    public HashSet<Orders> getOrdersList(){
        return iOrdersRepository.getOrdersList();
    }

    public Orders getOrdersById(Long OrdersId){
        return iOrdersRepository.getOrdersById(OrdersId);
    }


    public Orders cancelOrder(Long ordersId, Orders orders) {
        Orders ordersFromDB = getOrdersById(ordersId);
        ordersFromDB.setOrderStatus(orders.getOrderStatus());
        ordersFromDB.setOrderStatus((Orders.status.CANCELED));
        return iOrdersRepository.getOrdersById(ordersId);

    }
}
