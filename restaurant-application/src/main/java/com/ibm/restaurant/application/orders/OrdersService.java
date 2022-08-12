package com.ibm.restaurant.application.orders;

import com.ibm.restaurant.domain.menuItems.IMenuItemsRepository;
import com.ibm.restaurant.domain.menuItems.MenuItems;
import com.ibm.restaurant.domain.orders.IOrdersRepository;
import com.ibm.restaurant.domain.orders.OrderStatus;
import com.ibm.restaurant.domain.orders.Orders;
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
       // orders.setOrderStatus(Orders.status.IN_PROGRESS);
        iOrdersRepository.createOrder(orders);
    }


    public HashSet<Orders> getOrdersList(){
        return iOrdersRepository.getOrdersList();
    }



    public Orders getOrdersById(Long ordersId){
        return iOrdersRepository.getOrdersById(ordersId);
    }

    public Orders getOrdersPrice(Double ordersPrice){
        return iOrdersRepository.getOrdersPrice(ordersPrice);
    }


    public void cancelOrder(Long ordersId, Orders orders) {
        Orders ordersFromDB = getOrdersById(ordersId);
        //ordersFromDB.setOrderStatus(orders.getOrderStatus());
       // ordersFromDB.setOrderStatus((OrderStatus.CANCELED));
        iOrdersRepository.cancelOrder(ordersFromDB);

    }


}
