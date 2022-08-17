package com.ibm.restaurant.infrastructure.customer;

import com.ibm.restaurant.domain.customer.Customer;
import com.ibm.restaurant.domain.customer.CustomerRepository;
import com.ibm.restaurant.domain.tables.Tables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashSet;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    @Autowired
    private ICustomerRepositorySdj repositorySdj;

    @Override
    public Customer findById(Long id) {
        return repositorySdj.findById(id).orElse(null);
    }


    @Override
    public void save(Customer customer) {
        repositorySdj.save(customer);
    }

    @Override
    public void updateCustomer(Customer customer){
        repositorySdj.save(customer);
    }

    @Override
    public HashSet<Customer> getCustomerList() {

        return new HashSet<>(repositorySdj.findAll());
    }

}