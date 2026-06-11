package com.amin.e_commerce.bootstrap;


import com.amin.e_commerce.identity.role.application.service.RoleService;
import com.amin.e_commerce.identity.role.domain.model.SystemRole;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component
@Order(InitializerOrder.ROLE)
@RequiredArgsConstructor
public class SystemRoleInitializer implements CommandLineRunner {

    private final RoleService roleService;

    @Override
    public void run(String... args) {

        for (SystemRole systemRole : SystemRole.values()) {

            roleService.getOptionalByName(systemRole.getName().value())
                    .orElseGet(
                            () -> roleService.createSystemRole(systemRole)
                    );
        }
    }
}