package com.ibm.restaurant.orders;

import com.ibm.restaurant.domain.orders.Orders;
import com.ibm.restaurant.tables.TableMapperService;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class OrdersMapperService {

    private TableMapperService tableMapperService;
    public Orders mapOrderToDomain(OrdersDTO ordersDTO){
        Orders orders = new Orders(1L, ordersDTO.orderList);
        orders.setOrderId(ordersDTO.ordersId);
        orders.setOrderTime(ordersDTO.orderTime);
        orders.setOrderStatus(ordersDTO.orderStatus);
        orders.setOrderList(ordersDTO.orderList);
        return orders;
    }

    public OrdersDTO mapOrdersFromDomain(Orders orders){
        OrdersDTO ordersDTO = new OrdersDTO();
        ordersDTO.ordersId = orders.getOrderId();
        ordersDTO.orderStatus = orders.getOrderStatus();
        ordersDTO.orderList = orders.getOrderList();
        ordersDTO.orderTime = orders.getOrderTime();
        return ordersDTO;
    }

    public HashSet<OrdersDTO> mapOrdersFromDomainList(HashSet<Orders> ordersList){
        HashSet<OrdersDTO> ordersAUX = new HashSet<>();
        for(Orders orders: ordersList){
            ordersAUX.add(mapOrdersFromDomain(orders));
        }
        return ordersAUX;
    }



}
