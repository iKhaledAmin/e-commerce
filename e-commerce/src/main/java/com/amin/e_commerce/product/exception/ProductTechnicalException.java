package com.amin.e_commerce.product.exception;

import com.amin.e_commerce.core.exception.technical.TechnicalError;
import com.amin.e_commerce.core.exception.technical.TechnicalException;

public class ProductTechnicalException extends TechnicalException {
    // ----------------------------------- Constructors ----------------------------------- //
    protected ProductTechnicalException(TechnicalError error) {
        super(error);
    }

    // ----------------------------------- End Constructors ----------------------------------- //

    // ----------------------------------- Methods ----------------------------------- //
    public static ProductTechnicalException createCommandNull() {
        return new ProductTechnicalException(ProductTechnicalError.CREATE_COMMAND_NULL);
    }

    public static ProductTechnicalException updateCommandNull() {
        return new ProductTechnicalException(ProductTechnicalError.UPDATE_COMMAND_NULL);
    }
    // ----------------------------------- End Methods ----------------------------------- //
}
