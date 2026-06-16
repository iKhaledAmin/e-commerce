package com.amin.e_commerce.identity.capability.application.service;

import com.amin.e_commerce.identity.capability.domain.definition.CapabilityDefinition;
import com.amin.e_commerce.identity.capability.domain.model.Capability;
import com.amin.e_commerce.core.constant.SystemDomain;
import com.amin.e_commerce.identity.capability.domain.value.CapabilityCode;

import java.util.List;

public interface CapabilityManagementService {

    Capability create(CapabilityDefinition capability);
    Capability update(CapabilityCode code,CapabilityDefinition definition);
    void delete(CapabilityCode code);


    Capability viewCapability(CapabilityCode code);
    List<Capability> listCapabilities(SystemDomain domain);

}
