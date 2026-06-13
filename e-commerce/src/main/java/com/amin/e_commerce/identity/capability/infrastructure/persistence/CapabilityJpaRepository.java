package com.amin.e_commerce.identity.capability.infrastructure.persistence;

import com.amin.e_commerce.core.persistence.BaseRepository;
import com.amin.e_commerce.identity.capability.domain.model.Capability;
import com.amin.e_commerce.core.constant.SystemDomain;

import java.util.List;
import java.util.Optional;

public interface CapabilityJpaRepository extends BaseRepository<Capability, Long> {
    boolean existsByCode(String code);
    Optional<Capability> findByCode(String code);

    List<Capability> findAllByDomain(SystemDomain domain);

    Optional<Capability> findByCodeAndDomain(String name, String domain);
}
