package com.amin.e_commerce.identity.account.domain.repository;



import com.amin.e_commerce.core.pagination.PageResult;
import com.amin.e_commerce.identity.account.api.dto.AccountPageRequest;
import com.amin.e_commerce.identity.account.domain.model.Account;

import java.util.List;
import java.util.Optional;

public interface AccountRepository {

    Account save(Account account);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    boolean existsByRoleName(String roleName);

    boolean existsByRoleId(Long roleId);

    long countByRoleName(String roleName);

    Optional<Account> findByUsername(String username);

    Optional<Account> findByEmail(String email);

    Optional<Account> findByAccountCode(String accountCode);

    PageResult<Account> findAll(AccountPageRequest request);

    List<Account> findAllByRoleName(String roleName);
}