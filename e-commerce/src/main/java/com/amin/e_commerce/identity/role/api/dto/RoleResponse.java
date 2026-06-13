package com.amin.e_commerce.identity.role.api.dto;

import com.amin.e_commerce.identity.capability.api.dto.CapabilityResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class RoleResponse {

    @JsonProperty("name")
    private String name;

    @JsonProperty("display_name")
    private String displayName;

    @JsonProperty("description")
    private String description;

    @JsonProperty("is_default")
    private Boolean defaultRole;
    
    @JsonProperty("capabilities")
    private List<CapabilityResponse> capabilities;
}
