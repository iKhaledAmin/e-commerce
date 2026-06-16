package com.amin.e_commerce.identity.role.application.service;

import com.amin.e_commerce.identity.capability.domain.value.CapabilityCode;
import com.amin.e_commerce.identity.role.domain.value.RoleName;

public interface RoleCapabilityManagementService {
    void addCapability(RoleName roleName, CapabilityCode code);
    void removeCapability(RoleName roleName, CapabilityCode code);
    void cleanupCapability(CapabilityCode code);
}
