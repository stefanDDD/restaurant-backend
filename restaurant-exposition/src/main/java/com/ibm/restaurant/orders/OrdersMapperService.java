package com.ibm.restaurant.orders;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ibm.restaurant.domain.menuItems.MenuItems;
import com.ibm.restaurant.domain.orders.OrderStatus;
import com.ibm.restaurant.domain.orders.Orders;
import com.ibm.restaurant.menuItems.MenuItemsMapperService;
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



    public OrdersDTO mapOrdersFromDomain(Orders orders) {
        List<OrdersDTO> ordersDTO1 = new ArrayList<>();
        OrdersDTO ordersDTO = new OrdersDTO();
        ordersDTO.ordersId = orders.getOrderId();
        ordersDTO.orderStatus = orders.getOrderStatus();
        ordersDTO.ordersPrice = orders.getMenuItems().stream().mapToDouble(MenuItems::getMenuItemPrice).sum();
        ordersDTO.orderTime = orders.getOrderTime();
        ordersDTO.menuItemsDTO = orders.getMenuItems().stream().map(menuItemsMapperService::mapMenuItemsFromDomain).collect(Collectors.toList());
        ordersDTO.customerId = orders.getCustomerId().getCustomerId();
        return ordersDTO;
    }

    public HashSet<OrdersDTO> mapOrdersFromDomainList(HashSet<Orders> orders) {
        HashSet<OrdersDTO> ordersDTOList = new HashSet<>();
        for (Orders orders1 : orders) {
            ordersDTOList.add(mapOrdersFromDomain(orders1));
        }
        return ordersDTOList;
    }

    public Orders mapOrdersToDomain(OrdersDTO ordersDTO){
        Orders orders = new Orders();
        ordersDTO.menuItemsDTO = orders.getMenuItems().stream().map(menuItemsMapperService::mapMenuItemsFromDomain).collect(Collectors.toList());
        return orders;
    }

    public OrdersDTO mapOrdersToDomainGet(Orders orders){
        if (orders != null) {

            OrdersDTO ordersDTO = new OrdersDTO();
            ordersDTO.ordersId = orders.getOrderId();
            ordersDTO.orderTime = orders.getOrderTime();
            ordersDTO.ordersPrice = orders.getMenuItems().stream().mapToDouble(MenuItems::getMenuItemPrice).sum();
            ordersDTO.orderStatus = orders.getOrderStatus();
            ordersDTO.menuItemsDTO = orders.getMenuItems().stream().map(menuItemsMapperService::mapMenuItemsFromDomain).collect(Collectors.toList());
            ordersDTO.customerId = orders.getCustomerId().getCustomerId();
            return ordersDTO;
        }
        return null;
    }

    public Orders mapOrderToDomainCancel(OrdersDTO ordersDTO){
        Orders orders = new Orders();
        orders.setOrderStatus(OrderStatus.CANCELED);
        return orders;
    }

    public Orders mapOrderToDomainDelivery(OrdersDTO ordersDTO){
        Orders orders = new Orders();
        orders.setOrderStatus(OrderStatus.IN_DELIVERY);
        return orders;
    }

    public Orders mapOrderToDomainDelivered(OrdersDTO ordersDTO){
        Orders orders = new Orders();
        orders.setOrderStatus(OrderStatus.DELIVERED);
        return orders;
    }

    public OrdersDTO mapOrdersToDomainPrice(Orders orders){
        if (orders != null) {
            OrdersDTO ordersDTO = new OrdersDTO();
            ordersDTO.ordersPrice = orders.getMenuItems().stream().mapToDouble(MenuItems::getMenuItemPrice).sum();
            ordersDTO.customerId = orders.getCustomerId().getCustomerId();
            ordersDTO.ordersId = orders.getOrderId();
            return ordersDTO;
        }
        return null;
    }




}
