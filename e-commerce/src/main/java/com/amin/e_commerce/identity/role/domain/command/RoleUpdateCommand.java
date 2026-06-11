package com.amin.e_commerce.identity.role.domain.command;




import com.amin.e_commerce.identity.role.domain.value.RoleDescription;
import com.amin.e_commerce.identity.role.domain.value.RoleDisplayName;

import java.util.Optional;

public record RoleUpdateCommand(
        Optional<RoleDisplayName> displayName ,
        Optional<RoleDescription> description,
        Optional<Boolean> defaultRole,
        Optional<Boolean> protectedRole
) {

    public static RoleUpdateCommand of(
            String displayName,
            String description,
            Boolean defaultRole,
            Boolean protectedRole
    ){
        return new RoleUpdateCommand(
                Optional.ofNullable(displayName).map(RoleDisplayName::of),
                Optional.ofNullable(description).map(RoleDescription::of),
                Optional.ofNullable(defaultRole),
                Optional.ofNullable(protectedRole)
        );
    }
}