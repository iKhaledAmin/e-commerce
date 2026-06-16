package com.amin.e_commerce.identity.capability.application.service.impl;


import com.amin.e_commerce.core.constant.SystemDomain;
import com.amin.e_commerce.core.logging.audit.BusinessEventLogger;
import com.amin.e_commerce.identity.capability.application.service.CapabilityManagementService;
import com.amin.e_commerce.identity.capability.application.service.CapabilityQueryService;
import com.amin.e_commerce.identity.capability.domain.command.CapabilityCreateCommand;
import com.amin.e_commerce.identity.capability.domain.command.CapabilityUpdateCommand;
import com.amin.e_commerce.identity.capability.domain.definition.CapabilityDefinition;
import com.amin.e_commerce.identity.capability.domain.model.Capability;
import com.amin.e_commerce.identity.capability.domain.repository.CapabilityRepository;
import com.amin.e_commerce.identity.capability.domain.value.CapabilityCode;
import com.amin.e_commerce.identity.capability.exception.CapabilityTechnicalException;
import com.amin.e_commerce.identity.role.application.service.RoleCapabilityManagementService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class CapabilityManagementServiceImpl implements CapabilityManagementService {
    private final CapabilityRepository capabilityRepository;
    private final CapabilityQueryService capabilityQueryService;
    private final BusinessEventLogger businessEventLogger;
    private final RoleCapabilityManagementService roleCapabilityManagementService;


    @Transactional
    @Override
    public Capability create(CapabilityDefinition definition) {
        if (definition == null){
            throw CapabilityTechnicalException.nullCreateCommand();
        }

        CapabilityCreateCommand command = CapabilityCreateCommand.of(
                definition.getCode().toString(),
                definition.getResource().toString(),
                definition.getAction().toString(),
                definition.getName().toString(),
                definition.getDescription().toString(),
                definition.getDomain()
        );

        Capability newCapability = Capability.create(command);
        Capability saved = capabilityRepository.save(newCapability);

        businessEventLogger.capabilityCreated(
                saved.getCode()
        );

        return saved;
    }

    @Transactional
    @Override
    public Capability update(CapabilityCode code,CapabilityDefinition definition) {
        if (definition == null){
            throw CapabilityTechnicalException.nullUpdateCommand();
        }

        Capability existingCapability = capabilityQueryService.getByCode(code);

        if (!existingCapability.requiresUpdate(definition)) {
            return existingCapability;
        }

        CapabilityUpdateCommand command = CapabilityUpdateCommand.of(
                definition.getName().toString(),
                definition.getDescription().toString()
        );

        existingCapability.update(command);

        Capability saved = capabilityRepository.save(existingCapability);

        businessEventLogger.capabilityUpdated(
                saved.getCode()
        );

        return saved;
    }

    @Override
    @Transactional
    public void delete(CapabilityCode code) {

        Capability capability = capabilityQueryService.getByCode(code);

        roleCapabilityManagementService.cleanupCapability(code);

        capabilityRepository.flush();

        capabilityRepository.delete(capability);

        businessEventLogger.capabilityDeleted(code);

    }

    @Transactional(readOnly = true)
    @Override
    public Capability viewCapability(CapabilityCode code) {

        Capability capability = capabilityQueryService.getByCode(code);

        businessEventLogger.capabilityViewed(
                capability.getCode()
        );

        return capability;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Capability> listCapabilities(SystemDomain domain) {

        List<Capability> capabilities =
                domain == null ? capabilityQueryService.getAll() : capabilityQueryService.getByDomain(domain);

        businessEventLogger.capabilityListed(
                domain != null ? domain.name() : "ALL"
        );

        return capabilities;
    }

}
