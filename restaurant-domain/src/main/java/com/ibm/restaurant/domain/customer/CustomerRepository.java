package com.ibm.restaurant.domain.customer;
public interface CustomerRepository {

    void save(Customer customer);

    Customer findById(Long customerId);

    void updateCustomer(Customer customer);

}