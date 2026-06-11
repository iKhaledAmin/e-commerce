package com.amin.e_commerce.bootstrap;


import com.amin.e_commerce.identity.capability.application.port.CapabilityService;
import com.amin.e_commerce.identity.capability.application.registry.CapabilityRegistry;
import com.amin.e_commerce.identity.capability.domain.definition.CapabilityDefinition;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(InitializerOrder.CAPABILITY)
@Component
@RequiredArgsConstructor
public class CapabilityInitializer implements CommandLineRunner {
    private final CapabilityRegistry capabilityRegistry;
    private final CapabilityService capabilityService;

    @Override
    @Transactional
    public void run(String... args) {

        for (CapabilityDefinition definition : capabilityRegistry.getAll()) {

            if (!capabilityService.existsByCode(definition.getCode())) {
                capabilityService.create(definition);
            }

        }

    }
}
