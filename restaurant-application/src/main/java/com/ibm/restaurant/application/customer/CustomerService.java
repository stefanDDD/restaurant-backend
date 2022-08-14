package com.ibm.restaurant.application.customer;

import com.ibm.restaurant.domain.customer.Customer;
import com.ibm.restaurant.domain.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public void createCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    public void updateCustomer(Long customerId, Customer customer){
        Customer customer1 = getCustomerById(customerId);
        customer1.setAddress(customer.getAddress());
        customer1.setLastname(customer.getLastname());
        customer1.setName(customer.getName());
        customerRepository.updateCustomer(customer1);
    }

}