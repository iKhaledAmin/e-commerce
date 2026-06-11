package com.amin.e_commerce.security.provider;

import com.amin.e_commerce.security.principal.core.AuthenticatedPrincipal;

public interface CredentialAuthenticationService <P extends AuthenticatedPrincipal> {

    P authenticate(String subject, String credential);
}