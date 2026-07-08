package com.amin.e_commerce.identity.capability.exception;

import com.amin.e_commerce.core.exception.business.BusinessException;
import com.amin.e_commerce.core.exception.business.BusinessError;

public class CapabilityBusinessException extends BusinessException {

    // ----------------------------------- Constructors ----------------------------------- //

    private CapabilityBusinessException(BusinessError error) {
        super(error);
    }


    // ----------------------------------- Factories ----------------------------------- //

    public static CapabilityBusinessException notFound() {
        return new CapabilityBusinessException(CapabilityBusinessError.NOT_FOUND);
    }

}