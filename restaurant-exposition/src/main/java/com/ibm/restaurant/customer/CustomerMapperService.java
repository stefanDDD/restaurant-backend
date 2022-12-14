package com.ibm.restaurant.customer;

import com.ibm.restaurant.domain.customer.Address;
import com.ibm.restaurant.domain.customer.Customer;
import com.ibm.restaurant.domain.tables.Tables;
import com.ibm.restaurant.tables.TableDto;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class CustomerMapperService {


    public CustomerDTO mapFromDomain(Customer customer) {
        CustomerDTO customerDto = new CustomerDTO();
        customerDto.customerId = customer.getCustomerId();
        customerDto.lastname = customer.getLastname();
        customerDto.name = customer.getName();
        customerDto.addressDto = mapAddressFromDomain(customer.getAddress());
        return customerDto;
    }

    private AddressDTO mapAddressFromDomain(Address address) {
        AddressDTO dto = new AddressDTO();
        dto.addressLine1 = address.getAddressLine1();
        return dto;
    }

    public Customer mapToDomain(CustomerDTO dto) {
        Address address = null;
        if (dto.addressDto != null) {
            address = mapAddressDtoToDomain(dto.addressDto);
        }
        Customer customer = new Customer();
        customer.setName(dto.name);
        customer.setLastname(dto.lastname);
        customer.setAddress(address);
        return customer;
    }

    private Address mapAddressDtoToDomain(AddressDTO addressDto) {
        Address address = new Address();
        address.setAddressLine1(addressDto.addressLine1);
        return address;
    }

    public HashSet<CustomerDTO> mapFromDomainList(HashSet<Customer> customerHashSet) {
        HashSet<CustomerDTO> listAux = new HashSet<>();
        for (Customer customer : customerHashSet) {
            listAux.add(mapFromDomain(customer));

        }
        return listAux;
    }

}