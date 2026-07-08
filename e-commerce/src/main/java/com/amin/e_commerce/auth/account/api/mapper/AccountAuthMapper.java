package com.amin.e_commerce.auth.account.api.mapper;


import com.amin.e_commerce.auth.account.api.dto.AccountActivationResponse;
import com.amin.e_commerce.auth.account.api.dto.AccountLoginResponse;
import com.amin.e_commerce.auth.account.api.dto.AccountRegistrationRequest;
import com.amin.e_commerce.auth.account.api.dto.AccountRegistrationResponse;
import com.amin.e_commerce.auth.account.infrastructure.principal.AccountPrincipal;
import com.amin.e_commerce.auth.security.core.jwt.JwtMapper;
import com.amin.e_commerce.core.mapper.GlobalMapperConfig;
import com.amin.e_commerce.identity.account.api.dto.AccountCreateRequest;
import com.amin.e_commerce.identity.account.domain.model.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Mapper(config = GlobalMapperConfig.class,uses = JwtMapper.class)
public interface AccountAuthMapper {


    // ---------------- Registration ----------------

    @Mapping(target = "accountStatus", expression = "java(account.getAccountStatus().name())")
    @Mapping(target = "emailAddress", source = "emailAddress")
    AccountRegistrationResponse toRegistrationResponse(Account account);

    // ---------------- Activation ----------------

    @Mapping(target = "accountStatus", expression = "java(account.getAccountStatus().name())")
    @Mapping(target = "emailAddress", source = "emailAddress")
    AccountActivationResponse toActivationResponse(Account account);

    // ---------------- Login ----------------

    @Mapping(target = "account", source = "principal")
    @Mapping(target = "token", source = "jwtToken")
    AccountLoginResponse toLoginResponse(String jwtToken, AccountPrincipal principal);

    @Mapping(target = "accountCode", expression = "java(principal.getActorCode().toString())")
    @Mapping(target = "roles", expression = "java(mapRoles(principal.getRoles()))")
    @Mapping(target = "authorities", expression = "java(mapAuthorities(principal.getAuthorities()))")
    AccountLoginResponse.AccountInfo toAccountInfo(AccountPrincipal principal);

    // ---------------- Helpers ----------------


    default List<String> mapRoles(Set<String> roles) {
        return roles == null ? List.of() : new ArrayList<>(roles);
    }

    default List<String> mapAuthorities(Set<String> authorities) {
        return authorities == null ? List.of() : new ArrayList<>(authorities);
    }

    AccountCreateRequest toCreateRequest(AccountRegistrationRequest request);
}

