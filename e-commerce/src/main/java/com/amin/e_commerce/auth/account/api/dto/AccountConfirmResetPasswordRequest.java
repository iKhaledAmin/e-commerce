package com.amin.e_commerce.auth.account.api.dto;

import com.amin.e_commerce.identity.account.domain.value.RawPassword;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountConfirmResetPasswordRequest {

    private static final int PASSWORD_MIN_LENGTH = RawPassword.MIN_LENGTH;
    private static final int PASSWORD_MAX_LENGTH = RawPassword.MAX_LENGTH;
    private static final String PASSWORD_PATTERN = RawPassword.PATTERN;

    @NotBlank(message = "Reset code must not be blank")
    private String code;

    @NotEmpty(message = "Email address is mandatory")
    @NotBlank(message = "Email address is mandatory")
    @Email(message = "Invalid email address")
    @JsonProperty("email_address")
    private String emailAddress;

    @NotEmpty(message = "Password is mandatory")
    @NotBlank(message = "Password is mandatory")
    @Size(min = PASSWORD_MIN_LENGTH, max = PASSWORD_MAX_LENGTH, message = "Password length is invalid")
    @Pattern(regexp = PASSWORD_PATTERN, message = "Password format is invalid")
    @JsonProperty("password")
    private String password;
}