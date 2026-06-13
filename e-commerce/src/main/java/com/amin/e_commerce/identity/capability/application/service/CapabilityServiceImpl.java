package com.amin.e_commerce.identity.capability.application.service;


import com.amin.e_commerce.core.constant.SystemDomain;
import com.amin.e_commerce.core.logging.audit.BusinessEventLogger;
import com.amin.e_commerce.identity.capability.application.port.CapabilityService;
import com.amin.e_commerce.identity.capability.domain.command.CapabilityCreateCommand;
import com.amin.e_commerce.identity.capability.domain.command.CapabilityUpdateCommand;
import com.amin.e_commerce.identity.capability.domain.definition.CapabilityDefinition;
import com.amin.e_commerce.identity.capability.domain.model.Capability;
import com.amin.e_commerce.identity.capability.domain.repository.CapabilityRepository;
import com.amin.e_commerce.identity.capability.domain.value.CapabilityCode;
import com.amin.e_commerce.identity.capability.exception.CapabilityBusinessException;
import com.amin.e_commerce.identity.capability.exception.CapabilityTechnicalException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CapabilityServiceImpl implements CapabilityService {
    private final CapabilityRepository capabilityRepository;
    private final BusinessEventLogger businessEventLogger;

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

        Capability existingCapability = getByCode(code);

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
    public void delete(CapabilityCode code) {
        Capability capability = getByCode(code);

        capabilityRepository.delete(capability);

        businessEventLogger.capabilityDeleted(code);
    }

    @Transactional(readOnly = true)
    @Override
    public Capability viewCapability(CapabilityCode code) {

        Capability capability = getByCode(code);

        businessEventLogger.capabilityViewed(
                capability.getCode()
        );

        return capability;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Capability> listCapabilities(SystemDomain domain) {

        List<Capability> capabilities =
                domain == null ? getAll() : getByDomain(domain);

        businessEventLogger.capabilityListed(
                domain != null ? domain.name() : "ALL"
        );

        return capabilities;
    }



    // -------------------------------------- read operations -------------------------------------- //

    @Override
    public boolean existsByCode(CapabilityCode code) {
        return capabilityRepository.existsByCode(code);
    }

    @Override
    public Optional<Capability> getOptionalByCode(CapabilityCode code){
        return capabilityRepository.findByCode(code);
    }

    @Override
    public Capability getByCode(CapabilityCode code) {
        return getOptionalByCode(code)
                .orElseThrow(() -> CapabilityBusinessException.notFound()
                        .withClientDetails("reason", "Capability not found")
                        .withClientDetails("code", code.value())
                );
    }



    @Override
    public Optional<Capability> getOptionalByCodeAndModule(CapabilityCode code, SystemDomain domain) {
        return capabilityRepository.findByCodeAndDomain(code, domain);
    }


    @Override
    public List<Capability> getAll() {
        return capabilityRepository.findAll();
    }

    @Override
    public List<Capability> getByDomain(SystemDomain domain) {
        return capabilityRepository.findAllByDomain(domain);
    }



}
