package com.amin.e_commerce.bootstrap;

import com.amin.e_commerce.core.constant.SystemDomain;
import com.amin.e_commerce.core.logging.audit.SystemOperationLogger;
import com.amin.e_commerce.core.logging.definition.SystemOperationType;
import com.amin.e_commerce.core.logging.definition.SystemOperation;
import com.amin.e_commerce.identity.role.application.service.RoleService;
import com.amin.e_commerce.identity.role.domain.model.RoleDefinition;
import com.amin.e_commerce.identity.role.domain.value.RoleName;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Order(InitializerOrder.ROLE)
@RequiredArgsConstructor
public class RoleInitializer implements CommandLineRunner {

    private final RoleService roleService;
    private final SystemOperationLogger systemOperationLogger;

    @Override
    @Transactional
    public void run(String... args) {

        systemOperationLogger.started(
                SystemOperation.ROLE_SYNC,
                SystemOperationType.SYNCHRONIZATION,
                SystemDomain.IDENTITY
        );

        for (RoleDefinition definition : RoleDefinition.values()) {
            synchronize(definition);
        }

        systemOperationLogger.completed(
                SystemOperation.ROLE_SYNC,
                SystemOperationType.SYNCHRONIZATION,
                SystemDomain.IDENTITY
        );
    }

    private void synchronize(RoleDefinition definition) {

        roleService.getOptionalByName(definition.getName().value())
                .ifPresentOrElse(
                        role -> roleService.update(
                                RoleName.of(role.getName()),
                                definition
                        ),
                        () -> roleService.create(definition)
                );
    }
}