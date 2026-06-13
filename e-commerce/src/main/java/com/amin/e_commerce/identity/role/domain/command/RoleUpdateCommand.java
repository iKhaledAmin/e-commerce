package com.amin.e_commerce.identity.role.domain.command;

import com.amin.e_commerce.identity.role.domain.value.RoleDescription;
import com.amin.e_commerce.identity.role.domain.value.RoleDisplayName;

public record RoleUpdateCommand(RoleDisplayName displayName , RoleDescription description) {

    public static RoleUpdateCommand of(
            String displayName,
            String description
    ){
        return new RoleUpdateCommand(
                RoleDisplayName.of(displayName),
                RoleDescription.of(description)
        );
    }
}