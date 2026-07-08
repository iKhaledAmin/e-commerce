package com.amin.e_commerce.auth.account.infrastructure.authentication;

import com.amin.e_commerce.auth.account.infrastructure.principal.AccountPrincipal;
import com.amin.e_commerce.auth.security.core.authentication.CredentialAuthenticationService;
import com.amin.e_commerce.auth.security.exception.CustomSecurityException;
import com.amin.e_commerce.identity.account.application.service.AccountQueryService;
import com.amin.e_commerce.identity.account.domain.model.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountAuthenticationService implements CredentialAuthenticationService<AccountPrincipal> {

    private final AccountQueryService accountQueryService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public AccountPrincipal authenticate(String username, String password) {

        Account account = accountQueryService.getOptionalByUsername(username)
                .orElseThrow(() -> CustomSecurityException.invalidCredentials()
                        .withDebugDetails("problem", "Account not found")
                        .withDebugDetails("username",username)
                );

        if (!passwordEncoder.matches(password, account.getPassword())) {
            throw CustomSecurityException.invalidCredentials()
                    .withClientDetails("reason", "Invalid username or password")
                    .withDebugDetails("problem", "Invalid password");}

        if (account.getAccountStatus().isLocked()) {
            throw CustomSecurityException.principalLocked("Account")
                    .withDebugDetails("problem", "Account is locked");
        }

        if (!account.getAccountStatus().isActive()) {
            throw CustomSecurityException.principalInactive("Account")
                    .withDebugDetails("problem", "Account is inactive");
        }

        return AccountPrincipal.of(
                account.getUsername(),
                account.getAccountCode(),
                account.getAccountStatus(),
                account.getRoleNames(),
                account.getPermissions()
        );
    }
}