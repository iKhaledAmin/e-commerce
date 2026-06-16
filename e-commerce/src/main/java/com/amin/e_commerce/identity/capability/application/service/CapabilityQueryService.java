package com.amin.e_commerce.identity.capability.application.service;

import com.amin.e_commerce.core.constant.SystemDomain;
import com.amin.e_commerce.identity.capability.domain.model.Capability;
import com.amin.e_commerce.identity.capability.domain.value.CapabilityCode;

import java.util.List;
import java.util.Optional;

public interface CapabilityQueryService {
    boolean existsByCode(CapabilityCode code);

    Optional<Capability> getOptionalByCode(CapabilityCode code);
    Capability getByCode(CapabilityCode code);

    List<Capability> getByDomain(SystemDomain domain);
    Optional<Capability> getOptionalByCodeAndModule(CapabilityCode code, SystemDomain domain);

    List<Capability> getAll();
}
