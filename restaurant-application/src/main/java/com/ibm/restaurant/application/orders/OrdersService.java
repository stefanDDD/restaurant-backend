package com.ibm.restaurant.application.orders;

import com.ibm.restaurant.domain.IOrdersRepository;
import com.ibm.restaurant.domain.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrdersService {

    @Autowired
    private IOrdersRepository iOrdersRepository;

    public void create(Orders orders){

        iOrdersRepository.createOrder(orders);
    }

    public Orders getOrdersById(Long OrdersId){
        return iOrdersRepository.getOrdersById(OrdersId);
    }
}
