package com.amin.e_commerce.identity.account.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class AccountRoleResponse {

    @JsonProperty("display_name")
    private String displayName;

    @JsonProperty("name")
    private String name;

}
