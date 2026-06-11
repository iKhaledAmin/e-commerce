package com.amin.e_commerce.identity.core.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class IdentityResponse {
    @JsonProperty("actor_code")
    private String actorCode;

    @JsonProperty("actor_type")
    private String actorType;
}
