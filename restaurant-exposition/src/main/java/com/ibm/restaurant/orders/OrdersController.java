package com.ibm.restaurant.orders;

import com.ibm.restaurant.application.orders.OrdersService;
import com.ibm.restaurant.domain.menuItems.IMenuItemsRepository;
import com.ibm.restaurant.domain.orders.Orders;
import com.ibm.restaurant.domain.tables.Tables;
import com.ibm.restaurant.menuItems.MenuItemsMapperService;
import com.ibm.restaurant.tables.TableDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.Order;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
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
    public ResponseEntity<HashSet <OrdersDTO>> getOrdersList() {

        HashSet<Orders> ordersList = ordersService.getOrdersList();
        HashSet<OrdersDTO> ordersDTOList = ordersMapperService.mapOrdersFromDomainList(ordersList);
        return ResponseEntity.status(HttpStatus.OK).body(ordersDTOList);
    }
    @GetMapping("/byId/{ordID}")
    public ResponseEntity<OrdersDTO> getOrderById(Long ordID){
        Orders orders = ordersService.getOrdersById(ordID);
        OrdersDTO ordersDTO = ordersMapperService.mapOrdersFromDomain(orders);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(ordersDTO);

    }

    @PutMapping("/{ordersId}")
    public ResponseEntity<OrdersDTO> updateOrder(@RequestBody OrdersDTO ordersDTO){
        return Optional.ofNullable(ordersMapperService.mapOrdersToDomain(ordersDTO)).map(ordersObj -> {
            Orders ordersUpdate = ordersService.updateOrder(ordersObj);
            OrdersDTO ordersDTO1 = ordersMapperService.mapOrdersFromDomain(ordersUpdate);
            return ResponseEntity.status(HttpStatus.OK).body(ordersDTO1);
        }).orElse(null);

    }

    @GetMapping("/{orderID}")
    public ResponseEntity<Orders> cancelOrder(@PathVariable final Long orderID, final Orders orderStatus1){
        Orders orders = ordersService.getOrdersById(orderID);
        Orders orderStatus = ordersService.cancelOrder(orderID, orderStatus1);
        OrdersDTO ordersDTO = ordersMapperService.mapOrdersFromDomain(orders);
        return ResponseEntity.status(HttpStatus.OK).body(orderStatus);

    }










}
