package com.ibm.restaurant.exception;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExceptionDTO {

    @JsonProperty
    public String message;
    @JsonProperty
    public String code;
    @JsonProperty
    public Integer status;
}