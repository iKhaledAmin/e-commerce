package com.amin.e_commerce.identity.account.domain.command;

import com.amin.e_commerce.identity.account.domain.value.EmailAddress;
import com.amin.e_commerce.identity.account.domain.value.EncodedPassword;
import com.amin.e_commerce.identity.account.domain.value.Username;
import com.amin.e_commerce.identity.core.model.ActorCode;


public record AccountCreateCommand(
        ActorCode accountCode,
        Username username,
        EncodedPassword encodedPassword,
        EmailAddress emailAddress
) {

    public static AccountCreateCommand  of(
            ActorCode accountCode,
            String username,
            String encodedPassword,
            String email
    ) {
        return new AccountCreateCommand(
                accountCode,
                Username.of(username),
                EncodedPassword.of(encodedPassword),
                EmailAddress.of(email)
        );
    }

}