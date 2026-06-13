package com.amin.e_commerce.bootstrap;


import com.amin.e_commerce.core.constant.SystemDomain;
import com.amin.e_commerce.core.logging.audit.SystemOperationLogger;
import com.amin.e_commerce.core.logging.definition.SystemOperation;
import com.amin.e_commerce.core.logging.definition.SystemOperationType;
import com.amin.e_commerce.identity.account.api.dto.AccountCreateRequest;
import com.amin.e_commerce.identity.account.application.service.AccountService;
import com.amin.e_commerce.identity.account.domain.model.Account;
import com.amin.e_commerce.identity.core.model.ActorCode;
import com.amin.e_commerce.identity.role.application.service.RoleService;
import com.amin.e_commerce.identity.role.domain.model.Role;
import com.amin.e_commerce.identity.role.domain.model.RoleDefinition;
import com.amin.e_commerce.identity.role.domain.value.RoleName;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;


@Component
@Order(InitializerOrder.ADMIN)
@RequiredArgsConstructor
public class AdminInitializer implements CommandLineRunner {

    private final AccountService accountService;
    private final BootstrapProperties properties;
    private final SystemOperationLogger systemOperationLogger;
    private final RoleService roleService;

    @Override
    @Transactional
    public void run(String... args) {

        systemOperationLogger.started(
            SystemOperation.ADMIN_ACCOUNT_INITIALIZATION,
                SystemOperationType.INITIALIZATION,
                SystemDomain.BOOTSTRAP
        );

        RoleName adminRoleName = RoleDefinition.ADMIN.getName();

        if (accountService.existsByRoleName(adminRoleName.toString())) {

            systemOperationLogger.skipped(
                    SystemOperation.ADMIN_ACCOUNT_INITIALIZATION,
                    SystemOperationType.INITIALIZATION,
                    SystemDomain.BOOTSTRAP,
                    "One admin account already exists"
            );

            return;
        }

        List<Role> roles = roleService.getAll();

        AccountCreateRequest request = AccountCreateRequest.builder()
                .username(properties.admin().username())
                .password(properties.admin().password())
                .emailAddress(properties.admin().email())
                .firstName("System")
                .lastName("Administrator")
                .build();

        Account account = accountService.create(request, roles);

        ActorCode accountCode = ActorCode.of(account.getAccountCode());

        accountService.activate(accountCode);

        systemOperationLogger.completed(
                SystemOperation.ADMIN_ACCOUNT_INITIALIZATION,
                SystemOperationType.INITIALIZATION,
                SystemDomain.BOOTSTRAP
        );
    }
}