package com.amin.e_commerce.identity.account.application.service;



import com.amin.e_commerce.core.api.pagination.PageResult;
import com.amin.e_commerce.identity.account.api.dto.AccountCreateRequest;
import com.amin.e_commerce.identity.account.api.dto.AccountPageRequest;
import com.amin.e_commerce.identity.account.api.dto.ProfileUpdateRequest;
import com.amin.e_commerce.identity.account.domain.model.Account;
import com.amin.e_commerce.identity.account.domain.value.RawPassword;
import com.amin.e_commerce.identity.core.model.ActorCode;
import com.amin.e_commerce.identity.role.domain.model.Role;

import java.util.List;

public interface AccountManagementService {

    Account create(AccountCreateRequest request);
    Account create(AccountCreateRequest request, List<Role> roles);
    Account update(ActorCode accountCode, ProfileUpdateRequest request);

    Account activate(ActorCode accountCode);

    void resetPassword(ActorCode accountCode, RawPassword rawPassword);


    void login(ActorCode accountCode);

    Account viewAccount(ActorCode accountCode);
    Account viewMyAccount();
    PageResult<Account> listAccounts(AccountPageRequest request);



}
