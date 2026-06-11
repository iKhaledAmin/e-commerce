package com.amin.e_commerce.identity.role.domain.command;

import com.amin.e_commerce.identity.role.domain.model.RoleType;
import com.amin.e_commerce.identity.role.domain.value.RoleDisplayName;
import com.amin.e_commerce.identity.role.domain.value.RoleDescription;
import com.amin.e_commerce.identity.role.domain.value.RoleName;

public record RoleCreateCommand(
        RoleName name,
        RoleDisplayName displayName,
        RoleDescription description,
        boolean defaultRole,
        boolean protectedRole,
        RoleType roleType
) {

    public static RoleCreateCommand of(
        String name,
        String displayName,
        String description,
        boolean defaultRole,
        boolean protectedRole,
        RoleType roleType
    ){
        return new RoleCreateCommand(
                RoleName.of(name),
                RoleDisplayName.of(displayName),
                RoleDescription.of(description),
                defaultRole,
                protectedRole,
                roleType
        );

    }


}