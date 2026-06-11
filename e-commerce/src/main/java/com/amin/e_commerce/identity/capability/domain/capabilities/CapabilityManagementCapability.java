package com.amin.e_commerce.identity.capability.domain.capabilities;

import com.amin.e_commerce.core.constant.SystemDomain;
import com.amin.e_commerce.identity.capability.domain.definition.CapabilityDefinition;
import com.amin.e_commerce.identity.capability.domain.value.*;
import lombok.Getter;


@Getter
public enum CapabilityManagementCapability implements CapabilityDefinition {

    CAPABILITY_READ(
            "CAPABILITY_READ",
            "capability",
            "read",
            "Read Capabilities",
            "Allows viewing capability details",
            true
    ),


    ;

    private final CapabilityCode code;
    private final CapabilityResource resource;
    private final CapabilityAction action;
    private final CapabilityName name;
    private final CapabilityDescription description;
    private final boolean systemManaged;

    CapabilityManagementCapability(String code, String resource,
                                   String action, String name,
                                   String description, boolean systemManaged) {
        this.code = CapabilityCode.of(code);
        this.resource = CapabilityResource.of(resource);
        this.action = CapabilityAction.of(action);
        this.name = CapabilityName.of(name);
        this.description = CapabilityDescription.of(description);
        this.systemManaged = systemManaged;
    }


    @Override
    public SystemDomain getModule() {
        return SystemDomain.CAPABILITY;
    }
}