package com.amin.e_commerce.auth.account.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountLoginRequest {

    @NotEmpty(message = "Username is mandatory")
    @NotBlank(message = "Username is mandatory")
    @JsonProperty("username")
    private String username;

    @NotEmpty(message = "Password is mandatory")
    @NotBlank(message = "Password is mandatory")
    @JsonProperty("password")
    private String password;

}
