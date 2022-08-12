package com.ibm.restaurant.orders;

import com.ibm.restaurant.application.orders.OrdersService;
import com.ibm.restaurant.domain.menuItems.IMenuItemsRepository;
import com.ibm.restaurant.domain.orders.Orders;
import com.ibm.restaurant.menuItems.MenuItemsMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;
    @Autowired
    private OrdersMapperService ordersMapperService;
    @Autowired
    private MenuItemsMapperService menuItemsMapperService;


    @PostMapping
    public ResponseEntity<OrdersDTO> createOrders(@RequestBody final PlaceOrderDTO placeOrderDTO){
        Orders orders = ordersService.createOrders(placeOrderDTO.customerId, placeOrderDTO.menuItems);
        return ResponseEntity.status(HttpStatus.CREATED).body(ordersMapperService.mapOrdersFromDomain(orders));
    }

    @GetMapping
    public ResponseEntity<List<OrdersDTO>> getOrderList(){
        List<OrdersDTO> ordersList = ordersService.getOrdersList().stream().map(ordersMapperService::mapOrdersFromDomain).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(ordersList);

    }







}
