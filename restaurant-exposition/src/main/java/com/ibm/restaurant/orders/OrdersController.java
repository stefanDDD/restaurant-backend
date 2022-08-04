package com.ibm.restaurant.orders;

import com.ibm.restaurant.application.orders.OrdersService;
import com.ibm.restaurant.domain.orders.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;

@RestController
@RequestMapping("/api/v1/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private OrdersMapperService ordersMapperService;


    @PostMapping
    public ResponseEntity<Void> createOrders(@RequestBody OrdersDTO ordersDTO){

        Orders orders = ordersMapperService.mapOrderToDomain(ordersDTO);
        ordersService.createOrders(orders);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{ordersId}")
    public ResponseEntity<OrdersDTO> getOrdersById(@PathVariable Long ordersId){
        Orders orders = ordersService.getOrdersById(ordersId);
        OrdersDTO ordersDTO = ordersMapperService.mapOrdersFromDomain(orders);
        return ResponseEntity.status(HttpStatus.OK).body(ordersDTO);

    }

    @GetMapping("/ordersPrice")
    public ResponseEntity<OrdersDTO> getOrdersPrice(@PathVariable Double ordersPrice){
        Orders orders = ordersService.getOrdersPrice(ordersPrice);
        OrdersDTO ordersDTO = ordersMapperService.mapOrdersFromDomain(orders);
        return ResponseEntity.status(HttpStatus.OK).body(ordersDTO);
    }

    @GetMapping
    public ResponseEntity<HashSet <OrdersDTO>> getOrderList(){
        HashSet<Orders> ordersList = ordersService.getOrdersList();
        HashSet<OrdersDTO> ordersDTOList = ordersMapperService.mapOrdersFromDomainList(ordersList);
        return ResponseEntity.status(HttpStatus.OK).body(ordersDTOList);

    }


    @GetMapping("cancel/{ordersId}")
    public ResponseEntity<Orders> cancelOrder(@PathVariable Long ordersId, Orders orderStatus1){
        Orders orders = ordersService.getOrdersById(ordersId);
        Orders orderStatus = ordersService.cancelOrder(ordersId, orderStatus1);
        OrdersDTO ordersDTO = ordersMapperService.mapOrdersFromDomain(orders);
        return ResponseEntity.status(HttpStatus.OK).body(orderStatus);

    }


}
