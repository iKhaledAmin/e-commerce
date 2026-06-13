package com.amin.e_commerce.identity.account.api.dto;

import com.amin.e_commerce.identity.account.domain.value.EmailAddress;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class AccountUpdateRequest {

    private static final int EMAIL_ADDRESS_MAX_LENGTH = EmailAddress.MAX_LENGTH;


    @Size(max = EMAIL_ADDRESS_MAX_LENGTH, message = "Email address is too long")
    @Email(message = "Email address format is invalid")
    @JsonProperty("email_address")
    private String emailAddress;

    @Valid
    @JsonProperty("profile")
    private ProfileUpdateRequest profileUpdateRequest;
}
