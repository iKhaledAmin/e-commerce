package com.amin.e_commerce.customer.exception;

import com.amin.e_commerce.core.exception.technical.TechnicalError;
import com.amin.e_commerce.core.exception.technical.TechnicalException;


public class CustomerTechnicalException extends TechnicalException {
    // -------------------------------------------- Constructors -------------------------------------------- //

    protected CustomerTechnicalException(TechnicalError error) {
        super(error);
    }

//    protected CustomerTechnicalException(TechnicalError error, Throwable cause) {
//        super(error, cause);
//    }
//
//    protected CustomerTechnicalException(TechnicalError error, String message) {
//        super(error, message);
//    }
//
//    protected CustomerTechnicalException(TechnicalError error, String message, Throwable cause) {
//        super(error, message, cause);
//    }

    // -------------------------------------------- End Constructors -------------------------------------------- //

    // -------------------------------------------- Factory Methods -------------------------------------------- //

    public static CustomerTechnicalException nullAccount() {
        return new CustomerTechnicalException(CustomerTechnicalError.ACCOUNT_NULL);
    }

    // -------------------------------------------- End Factory Methods -------------------------------------------- //
}
