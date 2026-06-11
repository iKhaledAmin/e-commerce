package com.amin.e_commerce.identity.role.domain.definition;

import com.amin.e_commerce.identity.capability.domain.value.CapabilityCode;
import com.amin.e_commerce.identity.role.domain.model.SystemRole;
import java.util.Set;

public interface SystemRoleCapabilityDefinition {

    SystemRole getRole();

    Set<CapabilityCode> getCapabilityCodes();

}