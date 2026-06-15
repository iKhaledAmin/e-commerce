package com.amin.e_commerce.auth.account.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountActivationRequest {
    @NotBlank(message = "Activation code must not be blank")
    private String code;

    @NotBlank(message = "Email address must not be blank")
    @JsonProperty("email_address")
    private String emailAddress;
}
