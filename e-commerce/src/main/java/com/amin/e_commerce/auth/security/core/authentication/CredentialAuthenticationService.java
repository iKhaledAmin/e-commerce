package com.amin.e_commerce.auth.security.core.authentication;

public interface CredentialAuthenticationService <P extends AuthenticatedPrincipal> {

    P authenticate(String subject, String credential);
}