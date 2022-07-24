package com.ibm.restaurant.orders;

import com.ibm.restaurant.application.clients.ClientsService;
import com.ibm.restaurant.application.orders.OrdersService;
import com.ibm.restaurant.domain.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.Order;

@RestController
@RequestMapping("/api/clients")
public class OrdersController {

    @Autowired
    OrdersService ordersService;

    private OrdersMapperService ordersMapperService;


    @PostMapping
    public ResponseEntity<Void> createOrders(@RequestBody OrdersDTO ordersDTO){

        Orders orders = ordersMapperService.mapOrderToDomain(ordersDTO);
        ordersService.create(orders);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<OrdersDTO> getOrdersById(@PathVariable Long ordersId){
        Orders orders = ordersService.getOrdersById(ordersId);
        OrdersDTO ordersDTO = ordersMapperService.mapOrdersFromDomain(orders);
        return ResponseEntity.status(HttpStatus.OK).body(ordersDTO);
    }



}
