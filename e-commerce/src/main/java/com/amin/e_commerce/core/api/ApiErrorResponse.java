package com.amin.e_commerce.core.api;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class ApiErrorResponse {

    @JsonProperty("meta")
    private Meta meta;

    @JsonProperty("error")
    private ErrorResponse error;

}