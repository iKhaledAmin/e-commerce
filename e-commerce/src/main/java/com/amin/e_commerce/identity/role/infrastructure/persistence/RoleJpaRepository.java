package com.amin.e_commerce.identity.role.infrastructure.persistence;

import com.amin.e_commerce.identity.role.domain.model.Role;
import com.amin.e_commerce.core.persistence.BaseRepository;

import java.util.List;
import java.util.Optional;

public interface RoleJpaRepository extends BaseRepository<Role, Long> {

    Optional<Role> findByName(String name);

    List<Role> findAllByDefaultRoleTrue();

    boolean existsByDisplayName(String roleDisplayName);
    boolean existsByName(String name);

    List<Role> findAllByNameIn(List<String> names);
}
