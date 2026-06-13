package com.amin.e_commerce.identity.account.application.service;



import com.amin.e_commerce.core.pagination.PageResult;
import com.amin.e_commerce.identity.account.api.dto.AccountCreateRequest;
import com.amin.e_commerce.identity.account.api.dto.AccountPageRequest;
import com.amin.e_commerce.identity.account.api.dto.AccountUpdateRequest;
import com.amin.e_commerce.identity.account.domain.model.Account;
import com.amin.e_commerce.identity.account.domain.value.RawPassword;
import com.amin.e_commerce.identity.core.model.ActorCode;
import com.amin.e_commerce.identity.core.model.ActorIdentity;
import com.amin.e_commerce.identity.role.domain.model.Role;
import com.amin.e_commerce.identity.role.domain.value.RoleName;

import java.util.List;
import java.util.Optional;

public interface AccountService {

    Account create(AccountCreateRequest request);
    Account create(AccountCreateRequest request, List<Role> roles);
    Account update(ActorCode accountCode, AccountUpdateRequest request);

    void activate(ActorCode accountCode);

    void resetPassword(ActorCode accountCode, RawPassword rawPassword);

    Account assignRole(ActorCode accountCode, RoleName roleName);
    Account assignRoles(ActorCode accountCode, List<RoleName> roleNames);
    Account removeRole(ActorCode accountCode, RoleName roleName);
    Account replaceRoles(ActorCode accountCode, List<RoleName> roleNames);

    void login(ActorCode accountCode);

    Account viewAccount(ActorCode accountCode);
    Account viewMyAccount();
    PageResult<Account> listAccounts(AccountPageRequest request);


    boolean existsByRoleName(String roleName);

    Optional<Account> getOptionalByEmail(String email);

    Optional<Account> getOptionalByUsername(String username);

    Optional<Account> getOptionalByAccountCode(ActorCode accountCode);
    Account getByAccountCode(ActorCode accountCode);

    Account getByIdentity(ActorIdentity identity);

    PageResult<Account> getAll(AccountPageRequest request);


}
