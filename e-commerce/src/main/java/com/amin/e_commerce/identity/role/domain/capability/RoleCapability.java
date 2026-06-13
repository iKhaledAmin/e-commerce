package com.amin.e_commerce.identity.role.domain.capability;

import com.amin.e_commerce.identity.capability.domain.definition.CapabilityDefinition;
import com.amin.e_commerce.core.constant.SystemDomain;
import com.amin.e_commerce.identity.capability.domain.value.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RoleCapability implements CapabilityDefinition {

    ROLE_READ(
            "ROLE_READ",
            "role",
            "read",
            "Read Roles",
            "Allows viewing role clientDetails"
    ),


    ;


    private final CapabilityCode code;
    private final CapabilityResource resource;
    private final CapabilityAction action;
    private final CapabilityName name;
    private final CapabilityDescription description;
    RoleCapability(
            String code,
            String resource,
            String action,
            String name,
            String description
    ) {
        this.code = CapabilityCode.of(code);
        this.resource = CapabilityResource.of(resource);
        this.action = CapabilityAction.of(action);
        this.name = CapabilityName.of(name);
        this.description = CapabilityDescription.of(description);
    }

    @Override
    public SystemDomain getDomain() {
        return SystemDomain.ROLE;
    }
}