package com.amin.e_commerce.identity.account.domain.command;

import com.amin.e_commerce.identity.account.api.dto.AccountUpdateRequest;
import com.amin.e_commerce.identity.account.domain.value.EmailAddress;
import jakarta.validation.Valid;

import java.util.Optional;

public record AccountUpdateCommand(
        Optional<EmailAddress> email,
        Optional<ProfileUpdateCommand> profileCommand
) {

    public static AccountUpdateCommand of(String email, ProfileUpdateCommand profileCommand) {
        return new AccountUpdateCommand(
                Optional.ofNullable(email).map(EmailAddress::of),
                Optional.ofNullable(profileCommand)
        );
    }

    public static AccountUpdateCommand of(@Valid AccountUpdateRequest request) {
        return new AccountUpdateCommand(
                Optional.ofNullable(request.getEmailAddress()).map(EmailAddress::of),
                Optional.ofNullable(request.getProfileUpdateRequest()).map(ProfileUpdateCommand::of)
        );
    }
}