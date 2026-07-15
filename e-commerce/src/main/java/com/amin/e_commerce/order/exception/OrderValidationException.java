package com.amin.e_commerce.order.exception;

import com.amin.e_commerce.core.exception.validation.ValidationError;
import com.amin.e_commerce.core.exception.validation.ValidationException;

public class OrderValidationException extends ValidationException {
    // ------------------------------------ Constructors ------------------------------------ //
    protected OrderValidationException(ValidationError error) {
        super(error);
    }

    // ------------------------------------ End Constructors ------------------------------------ //

    // ------------------------------------ Static Methods ------------------------------------ //

    public static OrderValidationException invalidCode() {
        return new OrderValidationException(OrderValidationError.CODE_INVALID);
    }

    public static OrderValidationException invalidMoney() {
        return new OrderValidationException(OrderValidationError.MONEY_INVALID);
    }

    public static OrderValidationException invalidReservationCode() {
        return new OrderValidationException(OrderValidationError.RESERVATION_CODE_INVALID);
    }

    public static OrderValidationException invalidDeliveryAddress() {
        return new OrderValidationException(OrderValidationError.DELIVERY_ADDRESS_INVALID);
    }

    public static OrderValidationException invalidExpirationDate() {
        return new OrderValidationException(OrderValidationError.EXPIRATION_DATE_INVALID);
    }

    public static OrderValidationException invalidQuantity() {
        return new OrderValidationException(OrderValidationError.QUANTITY_INVALID);
    }

    public static OrderValidationException invalidSortField() {
        return new OrderValidationException(OrderValidationError.SORT_FIELD_INVALID);
    }

    // ------------------------------------ End Static Methods ------------------------------------ //
}
