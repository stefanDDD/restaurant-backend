package com.ibm.restaurant.clients;

import com.ibm.restaurant.application.clients.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservations")
public class ClientsController {

    @Autowired
    ClientsService clientsService;

    @PostMapping
    public void createClient(@RequestBody ClientsDTO clientsDTO){

    }
}
