package com.amin.e_commerce.identity.account.application.actor;

import com.amin.e_commerce.identity.core.model.Actor;
import com.amin.e_commerce.identity.core.model.ActorCode;
import com.amin.e_commerce.identity.core.model.ActorSource;
import com.amin.e_commerce.identity.core.model.ActorType;
import com.amin.e_commerce.identity.core.resolver.ActorSourceResolver;
import com.amin.e_commerce.identity.core.exception.IdentityTechnicalException;
import com.amin.e_commerce.identity.account.domain.model.Account;

public class AccountActorSourceResolver implements ActorSourceResolver {

    @Override
    public ActorType getType() {
        return ActorType.ACCOUNT;
    }

    @Override
    public Actor resolve(ActorSource source) {

        if (!(source instanceof Account account)) {
            throw IdentityTechnicalException.sourceTypeMismatch(
                    Account.class,
                    source.getClass()
            );
        }
        return new AccountActor(
                ActorCode.of(account.getAccountCode()),
                account.getRoleNames(),
                account.getPermissions()
        );
    }
}
