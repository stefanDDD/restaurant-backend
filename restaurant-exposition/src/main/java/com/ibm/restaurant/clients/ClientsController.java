package com.ibm.restaurant.clients;

import com.ibm.restaurant.application.clients.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clients")
public class ClientsController {

    @Autowired
    ClientsService clientsService;

    @PutMapping
    public void createClient(@RequestBody ClientsDTO clientsDTO){

    }
}
