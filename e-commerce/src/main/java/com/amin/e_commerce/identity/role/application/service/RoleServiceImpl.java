package com.amin.e_commerce.identity.role.application.service;


import com.amin.e_commerce.core.logging.audit.BusinessEventLogger;
import com.amin.e_commerce.identity.capability.application.port.CapabilityService;
import com.amin.e_commerce.identity.capability.domain.model.Capability;
import com.amin.e_commerce.identity.capability.domain.value.CapabilityCode;
import com.amin.e_commerce.identity.role.application.validation.RoleValidator;
import com.amin.e_commerce.identity.role.domain.command.RoleCreateCommand;
import com.amin.e_commerce.identity.role.domain.command.RoleUpdateCommand;
import com.amin.e_commerce.identity.role.domain.model.Role;
import com.amin.e_commerce.identity.role.domain.model.RoleDefinition;
import com.amin.e_commerce.identity.role.domain.repository.RoleRepository;
import com.amin.e_commerce.identity.role.domain.value.RoleName;
import com.amin.e_commerce.identity.role.exception.RoleBusinessException;
import com.amin.e_commerce.identity.role.exception.RoleTechnicalException;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


@AllArgsConstructor
@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final CapabilityService capabilityService;
    private final RoleValidator roleValidator;
    private final BusinessEventLogger businessEventLogger;

    public static final String DEFAULT_ROLES_CACHE = "defaultRoles";




    @Transactional
    @CacheEvict(value = DEFAULT_ROLES_CACHE, allEntries = true)
    @Override
    public Role create(RoleDefinition roleDefinition){
        if (roleDefinition == null){
           throw RoleTechnicalException.nullRoleDefinition();
        }

        // Application validation
        roleValidator.ensureCanBeCreate(roleDefinition);

        RoleCreateCommand command = RoleCreateCommand.of(
                roleDefinition.getName().toString(),
                roleDefinition.getDisplayName().toString(),
                roleDefinition.getDescription().toString(),
                roleDefinition.getRoleType(),
                roleDefinition.isDefaultRole()
        );

        // Domain logic
        Role role = Role.create(command);

        // Persistence
        Role savedRole = roleRepository.save(role);

        // Log business event
        businessEventLogger.roleCreated(
                savedRole.getName()
        );

        return savedRole;

    }

    @Transactional
    @CacheEvict(value = DEFAULT_ROLES_CACHE, allEntries = true)
    @Override
    public Role update(RoleName roleName,RoleDefinition roleDefinition) {
        if (roleDefinition == null){
            throw RoleTechnicalException.nullRoleDefinition();
        }

        Role existingRole = getByName(roleName);

        if (!existingRole.requiresUpdate(roleDefinition)) {
            return existingRole;
        }

        // Application validation
        roleValidator.ensureCanBeUpdate(existingRole, roleDefinition);

        RoleUpdateCommand command = RoleUpdateCommand.of(
                roleDefinition.getDisplayName().toString(),
                roleDefinition.getDescription().toString()
        );

        // Domain logic
        existingRole.update(command);

        // Persistence
        Role savedRole = roleRepository.save(existingRole);

        // Log business event
        businessEventLogger.roleUpdated(
                savedRole.getName()
        );

        return savedRole;
    }

    @Transactional
    @CacheEvict(value = DEFAULT_ROLES_CACHE, allEntries = true)
    @Override
    public void delete(RoleName roleName) {

        Role role = getByName(roleName);

        // Application validation
        roleValidator.ensureCanBeDelete(role);

        // Persistence
        roleRepository.delete(role);

        // Log business event
        businessEventLogger.roleDeleted(
                role.getName()
        );
    }

    @Transactional(readOnly = true)
    public Role viewRole(RoleName roleName) {

        Role role = getByName(roleName);

        businessEventLogger.roleViewed(
                role.getName()
        );

        return role;
    }


    @Transactional(readOnly = true)
    public List<Role> listRoles() {

        List<Role> roles = getAll();

        businessEventLogger.roleListed();

        return roles;
    }

    @Transactional
    @Override
    public void addCapability(RoleName roleName, CapabilityCode code) {

        Role role = getByName(roleName);

        Capability capability = capabilityService.getByCode(code);

        // Domain logic
        role.addCapability(capability);

        // Persistence
        roleRepository.save(role);

        businessEventLogger.roleCapabilityAssigned(
                role.getName(),
                capability.getCode()
        );

    }


    @Transactional
    @Override
    public void removeCapability(RoleName roleName, CapabilityCode code) {

        Role role = getByName(roleName);
        Capability capability = capabilityService.getByCode(code);

        // Domain logic
        role.removeCapability(capability);

        // Persistence
        roleRepository.save(role);

        businessEventLogger.roleCapabilityRemoved(
                role.getName(),
                capability.getCode()
        );
    }





    // ----------------------------------------- Retrieval methods ----------------------------------------- //

    @Cacheable(DEFAULT_ROLES_CACHE)
    @Override
    public List<Role> getDefaultRoles() {

        List<Role> roles = roleRepository.findDefaultRoles();

        if (roles.isEmpty()) {
            throw RoleTechnicalException.invalidRoleConfiguration();
        }

        return roles;
    }

    @Override
    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    @Override
    public Optional<Role> getOptionalByName(String roleName) {
        return roleRepository.findByName(roleName);
    }

    @Override
    public Role getByName(String roleName) {
        return getOptionalByName(roleName).orElseThrow(() -> RoleBusinessException.notFound()
                .withClientDetails("reason", "Role not found for given name")
        );
    }

    @Override
    public Role getByName(RoleName roleName) {
        return getByName(roleName.value());
    }

    @Override
    public List<Role> getAllByNames(List<RoleName> roleNames) {

        if (roleNames == null || roleNames.isEmpty()) {
            return List.of();
        }

        List<String> names = roleNames.
                stream()
                .filter(Objects::nonNull)
                .map(RoleName::value)
                .distinct()
                .toList();

        List<Role> roles = roleRepository.findAllByNameIn(names);

        if (roles.size() != roleNames.size()) {

            Set<String> foundNames = roles.stream()
                    .map(Role::getName)
                    .collect(Collectors.toSet());

            List<String> notFoundNames = names.stream()
                    .filter(name -> !foundNames.contains(name))
                    .toList();

            throw RoleBusinessException.someRolesNotFound()
                    .withClientDetails("requestedRoleNames", names)
                    .withClientDetails("notFoundRoleNames", notFoundNames);
        }

        return roles;
    }

    // ------------------------------------- End Retrieval methods ----------------------------------------- //


}



