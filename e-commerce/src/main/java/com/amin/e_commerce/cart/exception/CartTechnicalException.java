package com.amin.e_commerce.cart.exception;

import com.amin.e_commerce.core.exception.technical.TechnicalError;
import com.amin.e_commerce.core.exception.technical.TechnicalException;

public class CartTechnicalException extends TechnicalException {
    // ---------------------------------- Constructors ---------------------------------- //
    protected CartTechnicalException(TechnicalError error) {
        super(error);
    }

    // ---------------------------------- End Constructors ---------------------------------- //

    // ---------------------------------- Static Methods ---------------------------------- //

    public static CartTechnicalException nullOwnerIdentity() {
        return new CartTechnicalException(CartTechnicalError.OWNER_IDENTITY_NULL);
    }

    public static CartTechnicalException nullAddItemCommand() {
        return new CartTechnicalException(CartTechnicalError.ADD_ITEM_COMMAND_NULL);
    }

    public static CartTechnicalException nullUpdateItemQuantityCommand() {
        return new CartTechnicalException(CartTechnicalError.UPDATE_ITEM_QUANTITY_COMMAND_NULL);
    }


    // ---------------------------------- End Static Methods ---------------------------------- //
}
