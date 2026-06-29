package com.amin.e_commerce.auth.security.provider;

import com.amin.e_commerce.auth.security.principal.core.AuthenticatedPrincipal;

public interface CredentialAuthenticationService <P extends AuthenticatedPrincipal> {

    P authenticate(String subject, String credential);
}