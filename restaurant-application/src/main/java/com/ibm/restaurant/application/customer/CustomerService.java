package com.ibm.restaurant.application.customer;

import com.ibm.restaurant.domain.customer.Address;
import com.ibm.restaurant.domain.customer.Customer;
import com.ibm.restaurant.domain.customer.CustomerRepository;
import com.ibm.restaurant.domain.tables.Tables;
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
        Customer customerFromDB = getCustomerById(customerId);
        if(customerFromDB != null){
            customerFromDB.setName(customer.getName());
            customerFromDB.setLastname(customer.getLastname());
            customerFromDB.setAddress(customerFromDB.getAddress());
            customerRepository.updateCustomer(customerFromDB);
        }
    }

    public HashSet<Customer> getCustomerList()
    {
        return customerRepository.getCustomerList();
    }


}