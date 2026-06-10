package com.amin.e_commerce.core.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;


@Getter
@SuperBuilder
public class Meta {

    @JsonProperty("timestamp")
    private LocalDateTime timestamp;

    @JsonProperty("request_id")
    private String requestId;

}