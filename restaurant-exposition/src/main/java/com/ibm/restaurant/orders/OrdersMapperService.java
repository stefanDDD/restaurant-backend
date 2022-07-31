package com.ibm.restaurant.orders;

import com.ibm.restaurant.domain.Orders;
import com.ibm.restaurant.domain.Table;
import com.ibm.restaurant.tables.TableMapperService;
import org.springframework.stereotype.Service;

@Service
public class OrdersMapperService {

    private TableMapperService tableMapperService;
    public Orders mapOrderToDomain(OrdersDTO ordersDTO){
        Orders orders = new Orders(1L, ordersDTO.orderList);
        return orders;
    }

    public OrdersDTO mapOrdersFromDomain(Orders orders){
        OrdersDTO ordersDTO = new OrdersDTO();
        ordersDTO.ordersId = orders.getOrderId();
        return ordersDTO;
    }


}
