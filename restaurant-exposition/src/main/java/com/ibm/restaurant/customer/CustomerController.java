package com.ibm.restaurant.customer;

import com.ibm.restaurant.application.customer.CustomerService;
import com.ibm.restaurant.domain.customer.Customer;
import com.ibm.restaurant.domain.tables.Tables;
import com.ibm.restaurant.tables.TableDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerMapperService customerMapperService;
    @Autowired
    private CustomerService customerService;


    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Long id) {
        Customer customer = customerService.getCustomerById(id);
        return ResponseEntity.ok(customerMapperService.mapFromDomain(customer));
    }

    @PostMapping
    public ResponseEntity<Void> createCustomer(@RequestBody CustomerDTO dto) {
        Customer customer = customerMapperService.mapToDomain(dto);
        customerService.createCustomer(customer);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<Void> updateCustomer(@PathVariable Long customerId, @RequestBody CustomerDTO customerDTO){
        Customer customer = customerMapperService.mapToDomain(customerDTO);
        customerService.updateCustomer(customerId, customer);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping
    public ResponseEntity<HashSet<CustomerDTO>> getCustomerList()
    {

        HashSet<Customer> customerHashSet = customerService.getCustomerList();
        HashSet<CustomerDTO> customerDTOS = customerMapperService.mapFromDomainList(customerHashSet);
        return ResponseEntity.status(HttpStatus.OK).body(customerDTOS);
    }

}