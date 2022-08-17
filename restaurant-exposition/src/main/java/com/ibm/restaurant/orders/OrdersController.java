package com.ibm.restaurant.orders;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ibm.restaurant.application.orders.OrdersService;
import com.ibm.restaurant.domain.menuItems.MenuItems;
import com.ibm.restaurant.domain.orders.OrderStatus;
import com.ibm.restaurant.domain.orders.Orders;
import com.ibm.restaurant.menuItems.MenuItemsDTO;
import com.ibm.restaurant.menuItems.MenuItemsMapperService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.Order;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;


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
    public ResponseEntity<HashSet <OrdersDTO>> getOrdersList() {

        HashSet<Orders> ordersList = ordersService.getOrdersList();
        HashSet<OrdersDTO> ordersDTOList = ordersMapperService.mapOrdersFromDomainList(ordersList);
        return ResponseEntity.status(HttpStatus.OK).body(ordersDTOList);
    }


    @GetMapping("/{ordID}")
    public ResponseEntity<OrdersDTO> getOrderById(@PathVariable final Long ordID){
        Orders orders = ordersService.getOrdersById(ordID);
        OrdersDTO ordersDTO = ordersMapperService.mapOrdersToDomainGet(orders);
        return ResponseEntity.status(HttpStatus.OK).body(ordersDTO);

    }

    @RequestMapping(value = "/{orderId}", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateOrder(@PathVariable("orderId") Long orderId){
        OrdersDTO ordersDTO = new OrdersDTO();
        Orders orders = ordersMapperService.mapOrdersToDomain(ordersDTO);
        ordersService.updateOrder(orderId, orders);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

    @RequestMapping(value = "/cancel/{orderID:.*}", method = RequestMethod.GET)
    public ResponseEntity<Void> cancelOrder(@PathVariable("orderID") Long orderId){
        OrdersDTO ordersDTO = new OrdersDTO();
        Orders orders = ordersMapperService.mapOrderToDomainCancel(ordersDTO);
        ordersService.cancelOrder(orderId, orders);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

    @RequestMapping(value = "/delivery/{orderIDDelivery:.*}", method = RequestMethod.GET)
    public ResponseEntity<Void> readyToBeDeliveredOrder(@PathVariable("orderIDDelivery") Long orderIDDelivery){
        OrdersDTO ordersDTO = new OrdersDTO();
        Orders orders = ordersMapperService.mapOrderToDomainDelivery(ordersDTO);
        ordersService.readyToBeDeliveredOrder(orderIDDelivery, orders);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

    @RequestMapping(value = "/delivered/{orderIDDelivered:.*}", method = RequestMethod.GET)
    public ResponseEntity<Void> deliveredOrder(@PathVariable("orderIDDelivered") Long orderIDDelivered){
        OrdersDTO ordersDTO = new OrdersDTO();
        Orders orders = ordersMapperService.mapOrderToDomainDelivered(ordersDTO);
        ordersService.deliveredOrder(orderIDDelivered, orders);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }


    @GetMapping("/getPrice/{orderPriceID}")
    public ResponseEntity<OrdersDTO> getOrderPrice(@PathVariable final Long orderPriceID){
        Orders orders = ordersService.getOrderPrice(orderPriceID);
        return ResponseEntity.status(HttpStatus.OK).body(ordersMapperService.mapOrdersToDomainPrice(orders));

    }


}
