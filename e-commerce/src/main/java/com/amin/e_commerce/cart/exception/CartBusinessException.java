package com.amin.e_commerce.cart.exception;

import com.amin.e_commerce.core.exception.business.BusinessError;
import com.amin.e_commerce.core.exception.business.BusinessException;

public class CartBusinessException extends BusinessException {

    // ---------------------------------- Constructors ---------------------------------- //
    protected CartBusinessException(BusinessError error) {
        super(error);
    }

    // ---------------------------------- End Constructors ---------------------------------- //

    // ---------------------------------- Static Methods ---------------------------------- //

    public static CartBusinessException modificationNotAllowed() {
        return new CartBusinessException(CartBusinessError.MODIFICATION_NOT_ALLOWED);
    }

    public static CartBusinessException itemNotFound() {
        return new CartBusinessException(CartBusinessError.ITEM_NOT_FOUND);
    }

    // ---------------------------------- End Static Methods ---------------------------------- //
}
