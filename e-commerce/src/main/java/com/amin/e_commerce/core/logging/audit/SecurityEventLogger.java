package com.amin.e_commerce.core.logging.audit;

import com.amin.e_commerce.core.exception.security.SecurityException;


public interface SecurityEventLogger {

    void authenticationSucceeded(AuthenticatedPrincipal principal);
    void authenticationFailed(SecurityException ex);

    void authorizationDenied(String method, String path , String message);

    void loginSucceeded(AuthenticatedPrincipal principal);

    void loginFailed(String username, SecurityException ex);




}