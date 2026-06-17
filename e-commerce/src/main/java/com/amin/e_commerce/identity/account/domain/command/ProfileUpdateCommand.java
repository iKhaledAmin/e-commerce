package com.amin.e_commerce.identity.account.domain.command;



import com.amin.e_commerce.identity.account.api.dto.ProfileUpdateRequest;
import com.amin.e_commerce.identity.account.domain.model.Gender;
import com.amin.e_commerce.identity.account.domain.value.*;
import jakarta.validation.Valid;

import java.time.LocalDate;
import java.util.Optional;

public record ProfileUpdateCommand(
        Optional<FirstName> firstName,
        Optional<LastName> lastName,
        Optional<Gender> gender,
        Optional<BirthDate> birthDate,
        Optional<PhoneNumber> phoneNumber,
        Optional<Profession> profession
) {

    public static ProfileUpdateCommand of(
            String firstName,
            String lastName,
            Gender gender,
            LocalDate birthDate,
            String phoneNumber,
            String profession
    ) {
        return new ProfileUpdateCommand(
                Optional.ofNullable(firstName).map(FirstName::of),
                Optional.ofNullable(lastName).map(LastName::of),
                Optional.ofNullable(gender),
                Optional.ofNullable(birthDate).map(BirthDate::of),
                Optional.ofNullable(phoneNumber).map(PhoneNumber::of),
                Optional.ofNullable(profession).map(Profession::of)
        );
    }

    public static ProfileUpdateCommand of(@Valid ProfileUpdateRequest request) {
        return of(
                request.getFirstName(),
                request.getLastName(),
                request.getGender(),
                request.getBirthDate(),
                request.getPhoneNumber(),
                request.getProfession()
        );
    }
}