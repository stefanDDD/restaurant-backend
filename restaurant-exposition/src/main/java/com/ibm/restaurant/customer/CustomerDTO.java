package com.ibm.restaurant.customer;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ibm.restaurant.domain.customer.Address;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerDTO {

    @JsonProperty
    public Long customerId;

    @JsonProperty
    public String name;

    @JsonProperty
    public String lastname;

    @JsonProperty
    public AddressDTO addressDto;

    @JsonProperty
    public Address address;

}