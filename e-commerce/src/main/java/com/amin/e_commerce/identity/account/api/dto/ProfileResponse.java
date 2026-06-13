package com.amin.e_commerce.identity.account.api.dto;

import com.amin.e_commerce.identity.account.domain.model.Gender;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Getter
@Setter
@SuperBuilder
public class ProfileResponse {

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("birth_date")
    private LocalDate birthDate;

    @JsonProperty("phone_number")
    private String phoneNumber;

    @JsonProperty("profession")
    private String profession;

    @JsonProperty("gender")
    private Gender gender;

    @JsonProperty("profile_status")
    private ProfileStatus profileStatus;
}
