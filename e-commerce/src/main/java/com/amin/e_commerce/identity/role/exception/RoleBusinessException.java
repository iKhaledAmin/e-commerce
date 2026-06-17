package com.amin.e_commerce.identity.role.exception;

import com.amin.e_commerce.core.exception.business.BusinessError;
import com.amin.e_commerce.core.exception.business.BusinessException;

public class RoleBusinessException extends BusinessException {

    // ----------------------------------- Constructors ----------------------------------- //
    protected RoleBusinessException(BusinessError error) {
        super(error);
    }

    // ----------------------------------- Factories ----------------------------------- //


    public static RoleBusinessException notFound() {
        return new RoleBusinessException(RoleBusinessError.NOT_FOUND);
    }

    public static RoleBusinessException someRolesNotFound() {
        return new RoleBusinessException(RoleBusinessError.SOME_NOT_FOUND);
    }

    public static RoleBusinessException roleAssignedToAccounts() {
        return new RoleBusinessException(
                RoleBusinessError.ROLE_ASSIGNED_TO_ACCOUNTS
        );
    }

    public static RoleBusinessException nameAlreadyExists() {
        return new RoleBusinessException(
                RoleBusinessError.NAME_ALREADY_EXISTS
        );
    }

    public static RoleBusinessException displayNameAlreadyExists() {
        return new RoleBusinessException(
                RoleBusinessError.DISPLAY_NAME_ALREADY_EXISTS
        );
    }

    public static RoleBusinessException capabilityAlreadyAssigned() {
        return new RoleBusinessException(
                RoleBusinessError.CAPABILITY_ALREADY_ASSIGNED
        );
    }

    public static RoleBusinessException capabilityNotAssigned() {
        return new RoleBusinessException(
                RoleBusinessError.CAPABILITY_NOT_ASSIGNED
        );
    }
}
