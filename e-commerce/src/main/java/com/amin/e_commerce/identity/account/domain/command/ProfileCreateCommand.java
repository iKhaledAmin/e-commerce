package com.amin.e_commerce.identity.account.domain.command;


import com.amin.e_commerce.identity.account.domain.value.FirstName;
import com.amin.e_commerce.identity.account.domain.value.LastName;

public record ProfileCreateCommand(
        FirstName firstName,
        LastName lastName

) {
    public static ProfileCreateCommand of(String firstName , String lastName){
        return new ProfileCreateCommand(
                 FirstName.of(firstName),
                 LastName.of(lastName)
        );
    }
}
