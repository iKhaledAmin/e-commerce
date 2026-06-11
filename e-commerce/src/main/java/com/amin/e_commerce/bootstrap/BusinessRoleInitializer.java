package com.amin.e_commerce.bootstrap;

import com.amin.e_commerce.identity.role.api.dto.RoleCreateRequest;
import com.amin.e_commerce.identity.role.application.service.RoleService;
import com.amin.e_commerce.identity.role.domain.model.DefaultBusinessRole;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(InitializerOrder.ROLE)
@RequiredArgsConstructor
public class BusinessRoleInitializer implements CommandLineRunner {

    private final RoleService roleService;

    @Override
    public void run(String... args) throws Exception {
        for (DefaultBusinessRole businessRole : DefaultBusinessRole.values()) {

            roleService.getOptionalByName(businessRole.getName().value())
                    .orElseGet(
                            () -> roleService.createBusinessRole(
                                    RoleCreateRequest.builder()
                                            .name(businessRole.getName().value())
                                            .displayName(businessRole.getDisplayName().value())
                                            .description(businessRole.getDescription().value())
                                            .defaultRole(businessRole.isDefaultRole())
                                            .protectedRole(businessRole.isProtectedRole())
                                            .build()
                            )
                    );
        }
    }
}
