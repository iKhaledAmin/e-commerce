package com.amin.e_commerce.identity.account.infrastructure.persistence;

import com.amin.e_commerce.core.persistence.BaseRepository;
import com.amin.e_commerce.identity.account.domain.model.Account;

import java.util.List;
import java.util.Optional;

public interface AccountJpaRepository  extends BaseRepository<Account,Long> {

    Optional<Account> findByUsername(String username);

    boolean existsByUsername(String username);

    boolean existsByEmailAddress(String emailAddress);

    long countByAccountRolesRoleName(String roleName);

    boolean existsByAccountRolesRoleName(String roleName);

    boolean existsByAccountRolesRoleId(Long roleId);

    Optional<Account> findByEmailAddress(String email);

    Optional<Account> findByAccountCode(String accountCode);

    List<Account> findAllByAccountRolesRoleName(String roleName);
}
