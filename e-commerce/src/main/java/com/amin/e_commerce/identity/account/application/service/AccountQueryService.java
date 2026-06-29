package com.amin.e_commerce.identity.account.application.service;

import com.amin.e_commerce.core.api.pagination.PageResult;
import com.amin.e_commerce.identity.account.api.dto.AccountPageRequest;
import com.amin.e_commerce.identity.account.domain.model.Account;
import com.amin.e_commerce.identity.account.domain.value.EmailAddress;
import com.amin.e_commerce.identity.account.domain.value.Username;
import com.amin.e_commerce.identity.core.model.ActorCode;
import com.amin.e_commerce.identity.core.model.ActorIdentity;
import com.amin.e_commerce.identity.role.domain.value.RoleName;

import java.util.List;
import java.util.Optional;

public interface AccountQueryService {

    Optional<Account> getOptionalByEmail(EmailAddress emailAddress);
    Account getByEmail(EmailAddress emailAddress);

    Optional<Account> getOptionalByUsername(String username);
    Optional<Account> getOptionalByUsername(Username username);

    Optional<Account> getOptionalByAccountCode(ActorCode accountCode);
    Account getByAccountCode(ActorCode accountCode);

    Account getByIdentity(ActorIdentity identity);

    PageResult<Account> getAll(AccountPageRequest request);

    List<Account> getAllByRoleName(RoleName roleName);

    boolean existsByUsername(Username username);
}
