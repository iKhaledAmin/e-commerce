package com.amin.e_commerce.identity.account.application.service;

import com.amin.e_commerce.core.pagination.PageResult;
import com.amin.e_commerce.identity.account.api.dto.AccountPageRequest;
import com.amin.e_commerce.identity.account.domain.model.Account;
import com.amin.e_commerce.identity.core.model.ActorCode;
import com.amin.e_commerce.identity.core.model.ActorIdentity;
import com.amin.e_commerce.identity.role.domain.value.RoleName;

import java.util.List;
import java.util.Optional;

public interface AccountQueryService {

    boolean existsByRoleName(String roleName);

    Optional<Account> getOptionalByEmail(String email);
    Account getByEmail(String emailAddress);

    Optional<Account> getOptionalByUsername(String username);

    Optional<Account> getOptionalByAccountCode(ActorCode accountCode);
    Account getByAccountCode(ActorCode accountCode);

    Account getByIdentity(ActorIdentity identity);

    PageResult<Account> getAll(AccountPageRequest request);

    List<Account> getAllByRoleName(RoleName roleName);
}
