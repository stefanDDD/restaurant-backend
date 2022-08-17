package com.ibm.restaurant.customer;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddressDTO {

    @JsonProperty
    public String addressLine1;

}
