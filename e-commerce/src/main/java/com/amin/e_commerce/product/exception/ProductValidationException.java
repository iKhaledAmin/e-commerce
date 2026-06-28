package com.amin.e_commerce.product.exception;

import com.amin.e_commerce.core.exception.validation.ValidationError;
import com.amin.e_commerce.core.exception.validation.ValidationException;

public class ProductValidationException extends ValidationException {

    // ----------------------------------- Constructors ----------------------------------- //
    protected ProductValidationException(ValidationError error) {
        super(error);
    }

    // ----------------------------------- End Constructors ----------------------------------- //

    // ----------------------------------- Methods ----------------------------------- //

    public static ProductValidationException invalidSortField() {
        return new ProductValidationException(ProductValidationError.SORT_FIELD_INVALID);
    }

    public static ProductValidationException invalidCode() {
        return new ProductValidationException(ProductValidationError.CODE_INVALID);
    }

    public static ProductValidationException invalidName() {
        return new ProductValidationException(ProductValidationError.NAME_INVALID);
    }

    public static ProductValidationException invalidDescription() {
        return new ProductValidationException(ProductValidationError.DESCRIPTION_INVALID);
    }

    public static ProductValidationException invalidPrice() {
        return new ProductValidationException(ProductValidationError.PRICE_INVALID);
    }

    public static ProductValidationException invalidImage() {
        return new ProductValidationException(ProductValidationError.IMAGE_INVALID);
    }

    // ----------------------------------- End Methods ----------------------------------- //
}
