package com.amin.e_commerce.identity.account.application.service;

import com.amin.e_commerce.identity.account.domain.model.Account;
import com.amin.e_commerce.identity.core.model.ActorCode;
import com.amin.e_commerce.identity.role.domain.value.RoleName;

import java.util.List;

public interface AccountRoleManagement {

    Account assignRole(ActorCode accountCode, RoleName roleName);
    Account assignRoles(ActorCode accountCode, List<RoleName> roleNames);
    Account removeRole(ActorCode accountCode, RoleName roleName);
    Account replaceRoles(ActorCode accountCode, List<RoleName> roleNames);

    void cleanupRole(RoleName roleName);
}
