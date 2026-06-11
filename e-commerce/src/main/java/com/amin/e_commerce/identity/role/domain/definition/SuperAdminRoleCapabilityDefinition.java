package com.amin.e_commerce.identity.role.domain.definition;

import com.amin.e_commerce.identity.capability.application.port.CapabilityService;
import com.amin.e_commerce.identity.capability.domain.value.CapabilityCode;
import com.amin.e_commerce.identity.role.domain.model.SystemRole;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;


@AllArgsConstructor
@Component
public class SuperAdminRoleCapabilityDefinition implements SystemRoleCapabilityDefinition {
    private final CapabilityService capabilityService;

    @Override
    public SystemRole getRole() {
        return SystemRole.SUPER_ADMIN;
    }

    @Override
    public Set<CapabilityCode> getCapabilityCodes() {
        return capabilityService.getAll().
                stream()
                .map(capability -> CapabilityCode.of(capability.getCode()))
                .collect(Collectors.toSet());
    }
}

