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
        iOrdersRepository.createOrder(orders);
    }

    public HashSet<Orders> getOrdersList(){
        return iOrdersRepository.getOrdersList();
    }

    public Orders getOrdersById(Long OrdersId){
        return iOrdersRepository.getOrdersById(OrdersId);
    }


}
