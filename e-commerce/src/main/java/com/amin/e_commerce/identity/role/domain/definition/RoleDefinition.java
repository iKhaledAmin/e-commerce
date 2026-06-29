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

    // ------------------------------------ Identity Roles ------------------------------------  //

    USER(
            "USER",
            "User",
            "Default account identity role",
            RoleType.IDENTITY,
            true
    ),

    CUSTOMER(
            "CUSTOMER",
            "Customer",
            "Default customer role",
            RoleType.IDENTITY,
            true
    ),

    SELLER(
            "SELLER",
            "Seller",
            "Default seller role",
            RoleType.IDENTITY,
            false
    ),


    // ------------------------------------ Responsibility Roles ------------------------------------  //

    CATEGORY_MANAGER(
            "CATEGORY_MANAGER",
            "Category Manager",
            "Manage categories",
            RoleType.RESPONSIBILITY,
            false
    ),

    PRODUCT_MANAGER(
            "PRODUCT_MANAGER",
            "Product Manager",
            "Manage products",
            RoleType.RESPONSIBILITY,
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

        long defaultRoleCount = Arrays.stream(values())
                .filter(roleDefinition -> roleDefinition.defaultRole)
                .count();


        if (defaultRoleCount < 1) {
            throw RoleTechnicalException.defaultRoleNotConfigured();
        }

    }
}


