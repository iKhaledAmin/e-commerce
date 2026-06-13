package com.amin.e_commerce.identity.capability.domain.repository;

import com.amin.e_commerce.identity.capability.domain.model.Capability;
import com.amin.e_commerce.core.constant.SystemDomain;
import com.amin.e_commerce.identity.capability.domain.value.CapabilityCode;

import java.util.List;
import java.util.Optional;


public interface CapabilityRepository {
    Capability save(Capability capability);
    void delete(Capability capability);

    boolean existsByCode(CapabilityCode code);

    Optional<Capability> findByCode(CapabilityCode code);

    Optional<Capability> findByCodeAndDomain(CapabilityCode code, SystemDomain domain);

    List<Capability> findAllByDomain(SystemDomain domain);

    List<Capability> findAll();


}
