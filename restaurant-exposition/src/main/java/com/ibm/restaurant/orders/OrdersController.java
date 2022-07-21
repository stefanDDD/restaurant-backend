package com.ibm.restaurant.orders;

import com.ibm.restaurant.application.clients.ClientsService;
import com.ibm.restaurant.application.orders.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clients")
public class OrdersController {

    @Autowired
    OrdersService ordersService;

    @GetMapping
    public void CreateOrders(@RequestBody OrdersDTO ordersDTO){

    }


}
