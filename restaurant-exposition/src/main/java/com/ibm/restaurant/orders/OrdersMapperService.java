package com.ibm.restaurant.orders;

import com.ibm.restaurant.domain.menuItems.IMenuItemsRepository;
import com.ibm.restaurant.domain.menuItems.MenuItems;
import com.ibm.restaurant.domain.orders.Orders;
import com.ibm.restaurant.menuItems.MenuItemsDTO;
import com.ibm.restaurant.menuItems.MenuItemsMapperService;
import com.ibm.restaurant.tables.TableMapperService;
import org.apache.el.parser.ArithmeticNode;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrdersMapperService {

    @Autowired
    private MenuItemsMapperService menuItemsMapperService;
    public Orders mapOrderToDomain(final OrdersDTO ordersDTO){
            Orders orders = new Orders();
            orders.setOrderId(ordersDTO.ordersId);
            orders.setOrderTime(ordersDTO.orderTime);
            orders.setOrderStatus(ordersDTO.orderStatus);
            return orders;

    }


    public OrdersDTO mapOrdersFromDomain(Orders orders){
            OrdersDTO ordersDTO = new OrdersDTO();
            ordersDTO.ordersId = orders.getOrderId();
            ordersDTO.orderStatus = orders.getOrderStatus();
            ordersDTO.orderTime = orders.getOrderTime();
        ordersDTO.ordersList = orders.getMenuItems().stream().map(MenuItems::getMenuItemName).collect(Collectors.toList());
        ordersDTO.menuItemsDTO = orders.getMenuItems().stream().map(menuItemsMapperService::mapMenuItemsFromDomain).collect(Collectors.toSet());
        ordersDTO.ordersPrice = orders.getMenuItems().stream().mapToDouble(MenuItems::getMenuItemPrice).sum();

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
