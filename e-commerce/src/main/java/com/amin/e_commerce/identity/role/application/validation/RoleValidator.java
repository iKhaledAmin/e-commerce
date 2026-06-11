package com.amin.e_commerce.identity.role.application.validation;

import com.amin.e_commerce.identity.capability.domain.model.Capability;
import com.amin.e_commerce.identity.core.model.Actor;
import com.amin.e_commerce.identity.core.model.SystemActor;
import com.amin.e_commerce.identity.role.api.dto.RoleCreateRequest;
import com.amin.e_commerce.identity.role.api.dto.RoleUpdateRequest;
import com.amin.e_commerce.identity.role.application.service.RoleUsageService;
import com.amin.e_commerce.identity.role.exception.RoleBusinessException;
import com.amin.e_commerce.identity.role.domain.model.Role;
import com.amin.e_commerce.identity.role.domain.model.SystemRole;
import com.amin.e_commerce.identity.role.domain.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RoleValidator {

    private final RoleRepository roleRepository;
    private final RoleUsageService roleUsageService;

    public void ensureCanBeCreate(RoleCreateRequest request) {
        validateNameUniquenessFor(request.getName());
        validateDisplayNameUniquenessFor(request.getDisplayName());
    }

    public void ensureCanBeCreate(SystemRole systemRole) {
        validateNameUniquenessFor(systemRole.getName().toString());
        validateDisplayNameUniquenessFor(systemRole.getDisplayName().toString());

    }

    public void ensureCanBeUpdate(Role existing, RoleUpdateRequest request) {
        String newDisplayName = request.getDisplayName();
        if (newDisplayName != null && !existing.getDisplayName().equals(newDisplayName)) {
            validateDisplayNameUniquenessFor(newDisplayName);
        }
    }

    public void ensureCanBeDelete(Role role) {
        ensureRoleIsDeletable(role);
    }

    public void ensureCaAddCapability(Capability capability , Actor actor){
        if (capability.isSystemManaged() && !(actor instanceof SystemActor)){
            throw RoleBusinessException.systemManagedCapabilityCannotBeAssigned();
        }
    }

    public void ensureCaRemoveCapability(Capability capability , Actor actor){
        if (capability.isSystemManaged() && !(actor instanceof SystemActor)){
            throw RoleBusinessException.systemManagedCapabilityCannotBeRemoved();
        }
    }

    // ------------------------------------- PRIVATE METHODS ------------------------------------- //

    private void validateNameUniquenessFor(String name) {

        if (roleRepository.existsByName(name)) {
            throw RoleBusinessException.nameAlreadyExists()
                    .withClientDetails("roleName", name);
        }
    }

    private void validateDisplayNameUniquenessFor(String displayName) {

        if (roleRepository.existsByDisplayName(displayName)) {
            throw RoleBusinessException.displayNameAlreadyExists()
                    .withClientDetails("displayName", displayName);
        }
    }

    private void ensureRoleIsDeletable(Role role){
        if (roleUsageService.isAssignedToAnyAccount(role.getId())) {
            throw RoleBusinessException.roleAssignedToAccounts()
                    .withDebugDetails("roleName", role.getName());
        }
    }

    // ------------------------------------- PRIVATE METHODS ------------------------------------- //
}