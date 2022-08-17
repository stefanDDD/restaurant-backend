package com.ibm.restaurant.domain.customer;

import com.ibm.restaurant.domain.tables.Tables;

import java.util.HashSet;

public interface CustomerRepository {

    void save(Customer customer);

    Customer findById(Long customerId);

    void updateCustomer(Customer customer);

    HashSet<Customer> getCustomerList();


}