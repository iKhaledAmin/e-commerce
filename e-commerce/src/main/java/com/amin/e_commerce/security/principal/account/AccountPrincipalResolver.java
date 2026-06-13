package com.amin.e_commerce.security.principal.account;


import com.amin.e_commerce.identity.account.domain.model.Account;
import com.amin.e_commerce.identity.account.domain.repository.AccountRepository;
import com.amin.e_commerce.identity.core.model.ActorType;
import com.amin.e_commerce.security.exception.AuthenticationException;
import com.amin.e_commerce.security.jwt.JwtPayload;
import com.amin.e_commerce.security.principal.core.AuthenticatedPrincipal;
import com.amin.e_commerce.security.principal.core.PrincipalResolver;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AccountPrincipalResolver implements PrincipalResolver {

    private final AccountRepository accountRepository;

    @Override
    public ActorType getType() {
        return ActorType.ACCOUNT;
    }

    @Override
    @Transactional
    public AuthenticatedPrincipal resolve(JwtPayload payload) {

        Account account = accountRepository.findByUsername(payload.getSubject())
                .orElseThrow(() -> AuthenticationException.principalNotFound("Account not found")
                        .withDebugDetails("subject", payload.getSubject())
                        .withDebugDetails("actorCode", payload.getActorCode())
                        .withDebugDetails("actorType", payload.getActorType().name()));

        return AccountPrincipal.of(
                payload.getSubject(),
                payload.getActorCode().toString(),

                account.getAccountStatus().isActive(),
                account.getAccountStatus().isLocked(),

                payload.getRoles(),
                payload.getPermissions()
        );
    }
}