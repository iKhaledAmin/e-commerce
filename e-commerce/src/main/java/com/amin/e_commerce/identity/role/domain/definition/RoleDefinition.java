package com.amin.e_commerce.identity.role.domain.definition;

import com.amin.e_commerce.identity.role.domain.model.RoleType;
import com.amin.e_commerce.identity.role.domain.value.RoleDescription;
import com.amin.e_commerce.identity.role.domain.value.RoleDisplayName;
import com.amin.e_commerce.identity.role.domain.value.RoleName;
import com.amin.e_commerce.identity.role.exception.RoleTechnicalException;

import lombok.Getter;

import java.util.Arrays;


@Getter
public enum RoleDefinition {

    ADMIN(
            "ADMIN",
            "Administrator",
            "Full system access",
            RoleType.SYSTEM,
            false

    ),

    USER(
            "USER",
            "User",
            "Default system user",
            RoleType.SYSTEM,
            true
    ),

    CUSTOMER(
            "CUSTOMER",
            "Customer",
            "Default customer role",
            RoleType.BUSINESS,
            true
    ),

    SELLER(
            "SELLER",
            "Seller",
            "Default seller role",
            RoleType.BUSINESS,
            false
    )



    ;


    private final RoleName name;
    private final RoleDisplayName displayName;
    private final RoleDescription description;
    private final RoleType roleType;
    private final boolean defaultRole;


    RoleDefinition(String name, String displayName, String description, RoleType roleType, boolean defaultRole) {

        this.name = RoleName.of(name);
        this.displayName = RoleDisplayName.of(displayName);
        this.description = RoleDescription.of(description);
        this.roleType = roleType;
        this.defaultRole = defaultRole;
    }

    // Execute validation during enum initialization
    static {
        validateDefaultRole();
    }

    private static void validateDefaultRole() {

        long defaultSystemRoleCount = Arrays.stream(values())
                .filter(roleDefinition -> roleDefinition.roleType.isSystem() && roleDefinition.defaultRole)
                .count();

        long defaultBusinessRoleCount = Arrays.stream(values())
                .filter(roleDefinition -> roleDefinition.roleType.isBusiness() && roleDefinition.defaultRole)
                .count();

        if (defaultSystemRoleCount < 1) {
            throw RoleTechnicalException.defaultSystemRoleNotConfigured();
        }

        if (defaultBusinessRoleCount < 1) {
            throw RoleTechnicalException.defaultBusinessRoleNotConfigured();
        }
    }
}


