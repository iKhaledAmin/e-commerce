package com.amin.e_commerce.core.logging.event;

import com.amin.e_commerce.core.exception.business.BusinessException;
import com.amin.e_commerce.core.exception.policy.PolicyException;
import com.amin.e_commerce.core.exception.technical.TechnicalException;
import com.amin.e_commerce.core.exception.validation.ValidationException;
import org.springframework.web.bind.MethodArgumentNotValidException;

public interface ExceptionLogger {


    void log(BusinessException ex);

    void log(PolicyException ex);

    void log(TechnicalException ex);

    void log(ValidationException ex);

    void log(MethodArgumentNotValidException exception);

    void log(Exception ex);
}