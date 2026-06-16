package com.amin.e_commerce.bootstrap;

import com.amin.e_commerce.core.constant.SystemDomain;
import com.amin.e_commerce.core.logging.audit.SystemOperationLogger;
import com.amin.e_commerce.core.logging.definition.SystemOperation;
import com.amin.e_commerce.core.logging.definition.SystemOperationType;
import com.amin.e_commerce.identity.role.application.service.RoleManagementService;
import com.amin.e_commerce.identity.role.application.service.RoleQueryService;
import com.amin.e_commerce.identity.role.domain.definition.RoleDefinition;
import com.amin.e_commerce.identity.role.domain.model.Role;
import com.amin.e_commerce.identity.role.domain.value.RoleName;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@Order(InitializerOrder.ROLE)
@RequiredArgsConstructor
public class RoleInitializer implements CommandLineRunner {

    private final RoleManagementService roleManagementService;
    private final RoleQueryService roleQueryService;
    private final SystemOperationLogger systemOperationLogger;

    @Override
    @Transactional
    public void run(String... args) {

        systemOperationLogger.started(
                SystemOperation.ROLE_SYNC,
                SystemOperationType.SYNCHRONIZATION,
                SystemDomain.IDENTITY
        );

        synchronize();

        systemOperationLogger.completed(
                SystemOperation.ROLE_SYNC,
                SystemOperationType.SYNCHRONIZATION,
                SystemDomain.IDENTITY
        );
    }

    private void synchronize() {

        synchronizeDefinedRoles();

        removeObsoleteRoles();
    }

    /**
     * Create missing roles
     * and update existing roles.
     */
    private void synchronizeDefinedRoles() {

        for (RoleDefinition definition : RoleDefinition.values()) {

            roleQueryService.getOptionalByName(
                    definition.getName().value()
            ).ifPresentOrElse(
                    role -> roleManagementService.update(
                            RoleName.of(role.getName()),
                            definition
                    ),
                    () -> roleManagementService.create(
                            definition
                    )
            );
        }
    }

    /**
     * Remove roles that no longer exist
     * in RoleDefinition.
     */
    private void removeObsoleteRoles() {

        Set<String> definedRoles = Arrays.stream(RoleDefinition.values())
                .map(definition -> definition.getName().value())
                .collect(Collectors.toSet());

        for (Role role : roleQueryService.getAll()) {

            if (!definedRoles.contains(role.getName())) {
                roleManagementService.delete(
                        RoleName.of(role.getName())
                );
            }
        }
    }
}