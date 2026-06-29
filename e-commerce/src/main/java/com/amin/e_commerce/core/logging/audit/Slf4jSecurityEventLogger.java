package com.amin.e_commerce.core.logging.audit;


import com.amin.e_commerce.core.constant.SystemDomain;
import com.amin.e_commerce.core.logging.definition.EventType;
import com.amin.e_commerce.core.logging.definition.LogCategory;
import com.amin.e_commerce.core.logging.definition.SecurityEvent;
import com.amin.e_commerce.core.exception.security.SecurityException;
import com.amin.e_commerce.auth.security.principal.core.AuthenticatedPrincipal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j(topic = "SecurityEventLogger")
@Component
public class Slf4jSecurityEventLogger implements SecurityEventLogger {

    @Override
    public void authenticationSucceeded(AuthenticatedPrincipal principal) {

        log.atInfo()
                .addKeyValue("category", LogCategory.EVENT)
                .addKeyValue("type", EventType.SECURITY)
                .addKeyValue("domain", SystemDomain.AUTH)
                .addKeyValue("event", SecurityEvent.AUTHENTICATION_SUCCEEDED)
                .addKeyValue("authenticatedActorType", principal.getActorType().name())
                .addKeyValue("authenticatedActorCode", principal.getActorCode().toString())
                .addKeyValue("authenticatedActorSubject", principal.getSubject())
                .log("authentication succeeded");
    }

    @Override
    public void authenticationFailed( SecurityException ex) {

        log.atWarn()
                .addKeyValue("category", LogCategory.EVENT)
                .addKeyValue("type", EventType.SECURITY)
                .addKeyValue("domain", SystemDomain.AUTH)
                .addKeyValue("event", SecurityEvent.AUTHENTICATION_FAILED)
                .addKeyValue("errorCode", ex.getError().getCode())
                .addKeyValue("errorMessage", ex.getMessage())
                .addKeyValue("errorDetails", ex.getDebugDetails())
                .log("authentication failed");
    }

    @Override
    public void authorizationDenied(String method, String path, String message) {

        log.atWarn()
                .addKeyValue("category", LogCategory.EVENT)
                .addKeyValue("type", EventType.SECURITY)
                .addKeyValue("domain", SystemDomain.AUTH)
                .addKeyValue("event", SecurityEvent.AUTHORIZATION_DENIED)
                .addKeyValue("errorMessage", message)
                .addKeyValue("method", method)
                .addKeyValue("path", path)
                .log("authorization denied");

    }

    @Override
    public void loginSucceeded(AuthenticatedPrincipal principal) {

        log.atInfo()
                .addKeyValue("category", LogCategory.EVENT)
                .addKeyValue("type", EventType.SECURITY)
                .addKeyValue("domain", SystemDomain.AUTH)
                .addKeyValue("event", SecurityEvent.LOGIN_SUCCEEDED)
                .addKeyValue("loginActorType", principal.getActorType().name())
                .addKeyValue("loginActorCode", principal.getActorCode().toString())
                .addKeyValue("loginActorSubject", principal.getSubject())
                .log("login succeeded");

    }

    @Override
    public void loginFailed(String subject,SecurityException  ex) {


        log.atWarn()
                .addKeyValue("category", LogCategory.EVENT)
                .addKeyValue("type", EventType.SECURITY)
                .addKeyValue("domain", SystemDomain.AUTH)
                .addKeyValue("event", SecurityEvent.LOGIN_FAILED)
                .addKeyValue("subject", subject)
                .addKeyValue("errorCode", ex.getError().getCode())
                .addKeyValue("errorMessage", ex.getMessage())
                .addKeyValue("errorDetails", ex.getDebugDetails())
                .log("login failed");
    }

}