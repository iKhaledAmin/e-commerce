package com.amin.e_commerce.core.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.Map;


@Getter
@SuperBuilder
public class ErrorResponse {


    @JsonProperty("status")
    private int status;

    @JsonProperty("code")
    private String code;

    @JsonProperty("message")
    private String message;

    @JsonProperty("path")
    private String path;

    @JsonProperty("details")
    private Map<String,?> details;
}