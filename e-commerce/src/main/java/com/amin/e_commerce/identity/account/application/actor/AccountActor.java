package com.amin.e_commerce.identity.account.application.actor;

import com.amin.e_commerce.identity.core.model.ActorCode;
import com.amin.e_commerce.identity.core.model.ActorIdentity;
import com.amin.e_commerce.identity.core.model.ActorType;
import com.amin.e_commerce.identity.core.model.AbstractActor;

import java.util.Set;

public class AccountActor extends AbstractActor {

    private final Set<String> roles;
    private final Set<String> permissions;

    public AccountActor(ActorCode actorCode, Set<String> roles ,Set<String> permissions) {
        super(
                ActorIdentity.of(ActorType.ACCOUNT, actorCode)
        );

        this.roles = roles;
        this.permissions = permissions;
    }

    public boolean hasRole(String role) {
        return roles.contains(role);
    }

    public boolean hasAnyRole(String... roles) {
        for (String role : roles) {
            if (hasRole(role)) return true;
        }
        return false;
    }

    @Override
    public boolean hasAuthority(String authority) {
        return permissions.contains(authority);
    }
}