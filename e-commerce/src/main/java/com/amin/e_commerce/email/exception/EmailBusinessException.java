package com.amin.e_commerce.email.exception;

import com.amin.e_commerce.core.exception.business.BusinessException;
import com.amin.e_commerce.core.exception.business.BusinessError;

public class EmailBusinessException extends BusinessException {
    // -------------------------------------------- Constructors -------------------------------------------- //

    protected EmailBusinessException(BusinessError error) {
        super(error);
    }

//    protected EmailBusinessException(BusinessError error, Throwable cause) {
//        super(error, cause);
//    }
//
//    protected EmailBusinessException(BusinessError error, String message) {
//        super(error, message);
//    }
//
//    protected EmailBusinessException(BusinessError error, String message, Throwable cause) {
//        super(error, message, cause);
//    }

    // -------------------------------------------- Factories -------------------------------------------- //


    public static EmailBusinessException updateNotAllowed() {
        return new EmailBusinessException(EmailBusinessError.UPDATE_NOT_ALLOWED);
    }

    public static EmailBusinessException invalidTransition() {
        return new EmailBusinessException(
                EmailBusinessError.TRANSITION_INVALID
        );
    }

}
