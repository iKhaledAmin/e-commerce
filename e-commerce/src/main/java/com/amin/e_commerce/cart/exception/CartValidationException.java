package com.amin.e_commerce.cart.exception;

import com.amin.e_commerce.core.exception.validation.ValidationError;
import com.amin.e_commerce.core.exception.validation.ValidationException;

public class CartValidationException extends ValidationException {
    // ----------------------------------------- Constructors ----------------------------------------- //
    protected CartValidationException(ValidationError error) {
        super(error);
    }

    // ----------------------------------------- End Constructors ----------------------------------------- //

    // ----------------------------------------- Static Methods ----------------------------------------- //

    public static CartValidationException invalidQuantity() {
        return new CartValidationException(CartValidationError.QUANTITY_INVALID);
    }

    public static CartValidationException invalidUnitPrice() {
        return new CartValidationException(CartValidationError.UNIT_PRICE_INVALID);
    }

    // ----------------------------------------- End Static Methods ----------------------------------------- //
}
