package com.amin.e_commerce.auth.account.infrastructure.jwt;

import com.amin.e_commerce.auth.account.infrastructure.principal.AccountPrincipal;
import com.amin.e_commerce.auth.security.core.jwt.JwtClaims;
import com.amin.e_commerce.auth.security.core.jwt.JwtClaimsContributor;
import io.jsonwebtoken.JwtBuilder;
import org.springframework.stereotype.Component;

@Component
public class AccountJwtClaimsContributor
        implements JwtClaimsContributor<AccountPrincipal> {


    @Override
    public Class<AccountPrincipal> getSupportedPrincipal() {
        return AccountPrincipal.class;
    }

    @Override
    public void contribute(JwtBuilder builder, AccountPrincipal principal) {

        builder.claim(JwtClaims.ROLES, principal.getRoles());

        builder.claim(JwtClaims.AUTHORITIES, principal.getAuthorities());
    }
}