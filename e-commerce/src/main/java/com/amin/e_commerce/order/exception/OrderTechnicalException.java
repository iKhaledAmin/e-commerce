package com.amin.e_commerce.order.exception;

import com.amin.e_commerce.core.exception.technical.TechnicalError;
import com.amin.e_commerce.core.exception.technical.TechnicalException;

public class OrderTechnicalException extends TechnicalException {

    // ------------------------------------ Constructors ------------------------------------ //

    protected OrderTechnicalException(TechnicalError error) {
        super(error);
    }

    protected OrderTechnicalException(TechnicalError error, Throwable cause) {
        super(error, cause);
    }

    // ------------------------------------ End Constructors ------------------------------------ //

    // ------------------------------------ Static Methods ------------------------------------ //

    // ------------------------------------ End Static Methods ------------------------------------ //
}
