package com.amin.e_commerce.identity.capability.exception;

import com.amin.e_commerce.core.exception.business.BusinessException;
import com.amin.e_commerce.core.exception.business.BusinessError;

public class CapabilityBusinessException extends BusinessException {

    // ----------------------------------- Constructors ----------------------------------- //

    private CapabilityBusinessException(BusinessError error) {
        super(error);
    }

//    private CapabilityBusinessException(BusinessError error, Throwable cause) {
//        super(error, cause);
//    }
//
//    private CapabilityBusinessException(BusinessError error, String message) {
//        super(error, message);
//    }
//
//    private CapabilityBusinessException(BusinessError error, String message, Throwable cause) {
//        super(error, message, cause);
//    }

    // ----------------------------------- Factories ----------------------------------- //

    public static CapabilityBusinessException notFound() {
        return new CapabilityBusinessException(CapabilityBusinessError.NOT_FOUND);
    }

}