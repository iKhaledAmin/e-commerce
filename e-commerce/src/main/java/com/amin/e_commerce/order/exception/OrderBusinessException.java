package com.amin.e_commerce.order.exception;

import com.amin.e_commerce.core.exception.business.BusinessError;
import com.amin.e_commerce.core.exception.business.BusinessException;

public class OrderBusinessException extends BusinessException {
    // ------------------------------------ Constructors ------------------------------------ //
    protected OrderBusinessException(BusinessError error) {
        super(error);
    }

    protected OrderBusinessException(BusinessError error, Throwable cause) {
        super(error, cause);
    }


    // ------------------------------------ End Constructors ------------------------------------ //

    // ------------------------------------ Static Methods ------------------------------------ //

    public static OrderBusinessException orderAlreadyConfirmed() {
        return new OrderBusinessException(OrderBusinessError.ALREADY_CONFIRMED);
    }

    public static OrderBusinessException orderAlreadyCancelled() {
        return new OrderBusinessException(OrderBusinessError.ALREADY_CANCELLED);
    }

    public static OrderBusinessException orderAlreadyExpired() {
        return new OrderBusinessException(OrderBusinessError.ALREADY_EXPIRED);
    }

    public static OrderBusinessException notPaid() {
        return new OrderBusinessException(OrderBusinessError.NOT_PAID);
    }

    public static OrderBusinessException emptyCart() {
        return new OrderBusinessException(OrderBusinessError.EMPTY_CART);
    }

    public static OrderBusinessException placeOrderFiled(Throwable ex) {
        return new OrderBusinessException(OrderBusinessError.PLACE_ORDER_FILED, ex);
    }

    public static OrderBusinessException confirmOrderFiled(Throwable ex) {
        return new OrderBusinessException(OrderBusinessError.CONFIRM_ORDER_FILED, ex);
    }

    public static OrderBusinessException cancelOrderFiled(Throwable ex) {
        return new OrderBusinessException(OrderBusinessError.CANCEL_ORDER_FILED, ex);
    }


    public static OrderBusinessException notFound() {
        return new OrderBusinessException(OrderBusinessError.NOT_FOUND);
    }

    // ------------------------------------ End Static Methods ------------------------------------ //
}
