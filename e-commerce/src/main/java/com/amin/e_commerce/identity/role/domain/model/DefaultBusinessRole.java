package com.amin.e_commerce.identity.role.domain.model;

import com.amin.e_commerce.identity.role.domain.value.RoleDescription;
import com.amin.e_commerce.identity.role.domain.value.RoleDisplayName;
import com.amin.e_commerce.identity.role.domain.value.RoleName;
import lombok.Getter;

@Getter
public enum DefaultBusinessRole {

    CUSTOMER(
            "CUSTOMER",
            "Customer",
            "Default customer role",
            true,
            true
    ),

    SELLER(
            "SELLER",
            "Seller",
            "Seller role",
            false,
            false
    );

    private final RoleName name;
    private final RoleDisplayName displayName;
    private final RoleDescription description;
    private final boolean defaultRole;
    private final boolean protectedRole;

    DefaultBusinessRole(
            String name,
            String displayName,
            String description,
            boolean defaultRole,
            boolean protectedRole
    ) {
        this.name = RoleName.of(name);
        this.displayName = RoleDisplayName.of(displayName);
        this.description = RoleDescription.of(description);
        this.defaultRole = defaultRole;
        this.protectedRole = protectedRole;
    }
}