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

    public OrdersDTO mapOrdersFromDomain(final Orders orders) {
        OrdersDTO ordersDTO = new OrdersDTO();
        if(orders != null){
            ordersDTO.ordersId = orders.getOrderId();
            ordersDTO.orderStatus = orders.getOrderStatus();
            ordersDTO.orderTime = orders.getOrderTime();
            ordersDTO.menuItemsDTO = orders.getMenuItems().stream().map(menuItemsMapperService::mapMenuItemsFromDomain).collect(Collectors.toSet());
            ordersDTO.customerId = orders.getCustomer().getCustomerId();
        }
        return ordersDTO;
    }

}
