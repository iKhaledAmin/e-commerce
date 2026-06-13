package com.amin.e_commerce.identity.account.exception;

import com.amin.e_commerce.core.exception.business.BusinessError;
import com.amin.e_commerce.core.exception.business.BusinessException;

public class AccountBusinessException extends BusinessException {
    // -------------------------------------------- Constructors -------------------------------------------- //
    protected AccountBusinessException(BusinessError error) {
        super(error);
    }

//    protected AccountBusinessException(BusinessError error, Throwable cause) {
//        super(error, cause);
//    }
//
//    protected AccountBusinessException(BusinessError error, String message) {
//        super(error, message);
//    }
//
//    protected AccountBusinessException(BusinessError error, String message, Throwable cause) {
//        super(error, message, cause);
//    }

    // -------------------------------------------- Factory Method -------------------------------------------- //

    public static AccountBusinessException notFound() {
        return new AccountBusinessException(AccountBusinessError.NOT_FOUND);
    }

    public static AccountBusinessException duplicateRoles() {
        return new AccountBusinessException(AccountBusinessError.ROLE_DUPLICATE);
    }

    public static AccountBusinessException emptyRoleList() {
        return new AccountBusinessException(AccountBusinessError.ROLE_LIST_EMPTY);
    }

    public static AccountBusinessException missingSystemRole() {
        return new AccountBusinessException(AccountBusinessError.SYSTEM_ROLE_MISSING);
    }

    public static AccountBusinessException missingBusinessRole() {
        return new AccountBusinessException(AccountBusinessError.BUSINESS_ROLE_MISSING);
    }

    public static AccountBusinessException passwordResetNotAllowed() {
        return new AccountBusinessException(AccountBusinessError.PASSWORD_RESET_NOT_ALLOWED);
    }

    public static AccountBusinessException roleAssignNotAllowed() {
        return new AccountBusinessException(AccountBusinessError.ROLE_ASSIGN_NOT_ALLOWED);
    }

    public static AccountBusinessException roleRemovalNotAllowed() {
        return new AccountBusinessException(AccountBusinessError.ROLE_REMOVE_NOT_ALLOWED);
    }
    public static AccountBusinessException usernameAlreadyExists() {
        return new AccountBusinessException(AccountBusinessError.USERNAME_ALREADY_EXISTS);
    }

    public static AccountBusinessException emailAlreadyExists() {
        return new AccountBusinessException(AccountBusinessError.EMAIL_ALREADY_EXISTS);
    }

    public static AccountBusinessException lastAdminRemovalNotAllowed() {
        return new AccountBusinessException(AccountBusinessError.LAST_ADMIN_REMOVAL_NOT_ALLOWED);
    }


}
