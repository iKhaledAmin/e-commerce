package com.amin.e_commerce.auth.account.exception;

import com.amin.e_commerce.core.exception.business.BusinessError;
import com.amin.e_commerce.core.exception.business.BusinessException;

public class AuthException extends BusinessException {
    protected AuthException(BusinessError error) {
        super(error);
    }


    public static AuthException resetPasswordFailed() {
        return new AuthException(AuthError.RESET_PASSWORD_FAILED);
    }

    public static AuthException activationFailed() {
        return new AuthException(AuthError.ACTIVATION_FAILED);
    }
}
