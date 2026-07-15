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

    public static CartBusinessException itemNotFound() {
        return new CartBusinessException(CartBusinessError.ITEM_NOT_FOUND);
    }

    public static CartBusinessException cartPricesChanged() {
        return new CartBusinessException(CartBusinessError.CART_PRICES_CHANGED);
    }

    public static CartBusinessException emptyCart() {
        return new CartBusinessException(CartBusinessError.EMPTY_CART);
    }

    public static CartBusinessException alreadyShipped() {
        return new CartBusinessException(CartBusinessError.ALREADY_SHIPPED);
    }

    // ---------------------------------- End Static Methods ---------------------------------- //
}
