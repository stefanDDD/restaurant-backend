package com.ibm.restaurant.customer;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomerDTO {

    @JsonProperty
    public Long customerId;

    @JsonProperty
    public String name;

    @JsonProperty
    public String lastname;

    @JsonProperty
    public AddressDTO addressDto;

}