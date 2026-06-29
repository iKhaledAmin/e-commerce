package com.amin.e_commerce.identity.account.application.actor;


import com.amin.e_commerce.identity.core.exception.IdentityTechnicalException;
import com.amin.e_commerce.identity.core.model.Actor;
import com.amin.e_commerce.identity.core.model.ActorType;
import com.amin.e_commerce.identity.core.resolver.ActorPrincipalResolver;
import com.amin.e_commerce.auth.security.principal.account.AccountPrincipal;
import com.amin.e_commerce.auth.security.principal.core.AuthenticatedPrincipal;
import org.springframework.stereotype.Component;

@Component
public class AccountActorPrincipalResolver implements ActorPrincipalResolver {

    @Override
    public ActorType getType() {
        return ActorType.ACCOUNT;
    }

    @Override
    public Actor resolve(AuthenticatedPrincipal principal) {

        if (!(principal instanceof AccountPrincipal account)) {
            throw IdentityTechnicalException.principalTypeMismatch(
                    AccountPrincipal.class,
                    principal.getClass()
            );
        }

        return new AccountActor(
                account.getActorCode(),
                account.getRoles(),
                account.getPermissions()
        );
    }
}