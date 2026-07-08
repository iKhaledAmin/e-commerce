package com.amin.e_commerce.core.logging.event;

import com.amin.e_commerce.auth.security.core.authentication.AuthenticatedPrincipal;
import com.amin.e_commerce.auth.security.exception.CustomSecurityException;

public interface SecurityEventLogger {

    void authenticationSucceeded(AuthenticatedPrincipal principal);
    void authenticationFailed(CustomSecurityException ex);

    void authorizationDenied(String method, String path , String message);

    void loginSucceeded(AuthenticatedPrincipal principal);

    void loginFailed(String username, CustomSecurityException ex);





}