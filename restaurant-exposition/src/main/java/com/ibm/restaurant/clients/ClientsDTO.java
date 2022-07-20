package com.ibm.restaurant.clients;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClientsDTO {

    @JsonProperty
    public String firstName;

    @JsonProperty
    public String lastName;

    @JsonProperty
    public String phoneNumber;

    @JsonProperty
    public String emailAdress;
}
