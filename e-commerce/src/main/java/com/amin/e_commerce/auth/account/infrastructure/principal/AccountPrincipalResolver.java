package com.amin.e_commerce.auth.account.infrastructure.principal;


import com.amin.e_commerce.auth.security.core.authentication.AuthenticatedPrincipal;
import com.amin.e_commerce.auth.security.core.jwt.JwtPayload;
import com.amin.e_commerce.auth.security.core.principal.PrincipalResolver;
import com.amin.e_commerce.auth.security.exception.CustomSecurityException;
import com.amin.e_commerce.identity.account.application.service.AccountQueryService;
import com.amin.e_commerce.identity.account.domain.model.Account;
import com.amin.e_commerce.identity.core.model.ActorType;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AccountPrincipalResolver implements PrincipalResolver {

    private final AccountQueryService accountQueryService;

    @Override
    public ActorType getType() {
        return ActorType.ACCOUNT;
    }

    @Override
    @Transactional
    public AuthenticatedPrincipal resolve(JwtPayload payload) {

        Account account = accountQueryService.getOptionalByUsername(payload.getSubject())
                .orElseThrow(() -> CustomSecurityException.principalNotFound("Account not found")
                        .withDebugDetails("clientId", payload.getSubject())
                        .withDebugDetails("actorCode", payload.getActorCode())
                        .withDebugDetails("actorType", payload.getActorType().name()));

        return AccountPrincipal.of(
                payload.getSubject(),
                payload.getActorCode().toString(),

                account.getAccountStatus(),

                payload.getRoles(),
                payload.getAuthorities()
        );
    }
}