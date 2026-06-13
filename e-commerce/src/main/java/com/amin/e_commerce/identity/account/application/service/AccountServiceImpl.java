package com.amin.e_commerce.identity.account.application.service;


import com.amin.e_commerce.core.logging.audit.BusinessEventLogger;
import com.amin.e_commerce.core.pagination.PageResult;
import com.amin.e_commerce.identity.account.api.dto.AccountCreateRequest;
import com.amin.e_commerce.identity.account.api.dto.AccountPageRequest;
import com.amin.e_commerce.identity.account.api.dto.AccountUpdateRequest;
import com.amin.e_commerce.identity.account.application.validation.AccountApplicationValidator;
import com.amin.e_commerce.identity.account.domain.command.AccountUpdateCommand;
import com.amin.e_commerce.identity.account.domain.model.Account;
import com.amin.e_commerce.identity.account.domain.model.AccountFactory;
import com.amin.e_commerce.identity.account.domain.repository.AccountRepository;
import com.amin.e_commerce.identity.account.domain.value.EncodedPassword;
import com.amin.e_commerce.identity.account.domain.value.RawPassword;
import com.amin.e_commerce.identity.account.exception.AccountBusinessException;
import com.amin.e_commerce.identity.account.exception.AccountTechnicalException;
import com.amin.e_commerce.identity.core.model.Actor;
import com.amin.e_commerce.identity.core.model.ActorCode;
import com.amin.e_commerce.identity.core.model.ActorIdentity;
import com.amin.e_commerce.identity.core.provider.ActorProvider;
import com.amin.e_commerce.identity.role.application.service.RoleService;
import com.amin.e_commerce.identity.role.domain.model.Role;
import com.amin.e_commerce.identity.role.domain.model.RoleDefinition;
import com.amin.e_commerce.identity.role.domain.value.RoleName;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@AllArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final AccountFactory accountFactory;
    private final RoleService roleService;
    private final ActorProvider actorProvider;
    private final AccountApplicationValidator accountValidator;
    private final PasswordEncoder passwordEncoder;
    private final BusinessEventLogger businessEventLogger;


    @Transactional
    @Override
    public Account create(AccountCreateRequest request) {
        List<Role> roles = roleService.getDefaultRoles();
        return create(request, roles);
    }

    @Transactional
    @Override
    public Account create(AccountCreateRequest request, List<Role> roles) {

        String encodedPassword = passwordEncoder.encode(request.getPassword());

        // Application validation
        accountValidator.validateCreate(request);

        // Domain logic
        Account account = accountFactory.create(
                request.getUsername(),
                encodedPassword,
                request.getEmailAddress(),
                request.getFirstName(),
                request.getLastName(),
                roles
        );

        // Persist
        Account saved = accountRepository.save(account);

        // Log the business operation event
        businessEventLogger.accountCreated(
                saved.getAccountCode()
        );

        return saved;
    }


    @Transactional
    @Override
    public Account update(ActorCode accountCode, AccountUpdateRequest request) {

        Account target = getByAccountCode(accountCode);

        AccountUpdateCommand command = AccountUpdateCommand.of(request);

        // Application validation
        accountValidator.validateUpdate(target, request);

        // Domain logic
        target.update(command);

        // Persist
        Account saved = accountRepository.save(target);

        // Log the business operation event
        businessEventLogger.accountUpdated(
                saved.getAccountCode()
        );

        return saved;
    }

    @Transactional
    @Override
    public void activate(ActorCode accountCode) {
        Account target = getByAccountCode(accountCode);

        // Domain logic
        target.activate();

        // Persist
        Account saved = accountRepository.save(target);

        // Log the business operation event
        businessEventLogger.accountActivated(
                saved.getAccountCode()
        );

    }

    @Transactional
    @Override
    public void resetPassword(ActorCode accountCode, RawPassword rawPassword) {

        Account target = getByAccountCode(accountCode);

        EncodedPassword encodedPassword = EncodedPassword.of(
                passwordEncoder.encode(rawPassword.toString())
        );

        // Domain logic
        target.resetPassword(encodedPassword);

        // Persist
        Account saved = accountRepository.save(target);

        // Log the business operation event
        businessEventLogger.accountPasswordReset(
                saved.getAccountCode()
        );

    }

    @Transactional
    @Override
    public Account assignRole(ActorCode accountCode, RoleName roleName) {

        Account target = getByAccountCode(accountCode);
        Role role = roleService.getByName(roleName);

        // Domain logic
        target.assignRole(role);

        // Persist
        Account saved = accountRepository.save(target);

        // Log the business operation event
        businessEventLogger.accountRoleAssigned(
                saved.getAccountCode(),
                role.getName()
        );

        return saved;
    }

    @Transactional
    @Override
    public Account assignRoles(ActorCode accountCode, List<RoleName> roleNames) {

        // todo verify roleNames not null or empty

        Account target = getByAccountCode(accountCode);
        List<Role> fetchedRoles = roleService.getAllByNames(roleNames);

        // Domain logic
        target.assignRoles(fetchedRoles);

        // Persist
        Account saved = accountRepository.save(target);

        // Log the business operation event
        businessEventLogger.accountRolesAssigned(
                saved.getAccountCode(),
                fetchedRoles.stream().map(Role::getName).toList()
        );

        return saved;
    }

    @Transactional
    @Override
    public Account removeRole(ActorCode accountCode, RoleName roleName) {

        Account target = getByAccountCode(accountCode);
        Role role = roleService.getByName(roleName);

        // Application-business-rule
        ensureAtLeastAdminStillExists(target,role);

        // Domain logic
        target.removeRole(role);

        // Persist
        Account saved = accountRepository.save(target);

        // Log the business operation event
        businessEventLogger.accountRoleRemoved(
                saved.getAccountCode(),
                role.getName()
        );

        return saved;
    }


    @Transactional
    @Override
    public Account replaceRoles(ActorCode accountCode, List<RoleName> roleNames) {

        Account target = getByAccountCode(accountCode);

        List<Role> fetchedRoles = roleService.getAllByNames(roleNames);


        // Business rule
        ensureAtLeastAdminStillExists(target, fetchedRoles);

        // Domain logic
        target.replaceRoles(fetchedRoles);

        // Persist
        Account saved = accountRepository.save(target);

        // Log the business operation event
        businessEventLogger.accountRolesReplaced(
                saved.getAccountCode(),
                fetchedRoles.stream().map(Role::getName).toList()
        );

        return saved;
    }

    @Override
    public void login(ActorCode accountCode) {
        Account account = getByAccountCode(accountCode);
        account.login();
        accountRepository.save(account);
    }


    @Transactional(readOnly = true)
    public Account viewAccount(ActorCode accountCode) {

        Account account = getByAccountCode(accountCode);

        businessEventLogger.accountViewed(
                account.getAccountCode()
        );

        return account;
    }

    @Transactional(readOnly = true)
    public Account viewMyAccount() {

        Actor actor = actorProvider.getCurrent();

        Account account = getByIdentity(
                actor.getActorIdentity()
        );

        businessEventLogger.accountViewed(
                account.getAccountCode()
        );

        return account;
    }

    @Transactional(readOnly = true)
    public PageResult<Account> listAccounts(AccountPageRequest request) {

        PageResult<Account> accounts = accountRepository.findAll(request);

        businessEventLogger.accountListed(
                request.getPage(),
                request.getSize(),
                request.getSortBy().toString(),
                request.getDirection().toString()
        );

        return accounts;
    }

    // -------------------------------- Retrieval -------------------------------- //


    @Override
    public boolean existsByRoleName(String roleName) {
        return accountRepository.existsByRoleName(roleName);
    }

    @Override
    public Optional<Account> getOptionalByEmail(String email) {
        return accountRepository.findByEmail(email);
    }

    @Override
    public Optional<Account> getOptionalByUsername(String username) {
        return accountRepository.findByUsername(username);
    }

    public Optional<Account> getOptionalByAccountCode(ActorCode accountCode) {
        return accountRepository.findByAccountCode(accountCode.getValue());
    }

    public Account getByAccountCode(ActorCode accountCode){
        return getOptionalByAccountCode(accountCode).orElseThrow(() -> AccountBusinessException.notFound()
                .withClientDetails("reason", "Account not found for given code")
                .withDebugDetails("accountCode", accountCode.getValue())
        );
    }

    @Override
    public Account getByIdentity(ActorIdentity identity) {

        if (identity == null) {
            throw AccountTechnicalException.nullActorIdentity();
        }

        ActorCode accountCode = identity.getActorCode();

        Account account = getOptionalByAccountCode(accountCode)
                .orElseThrow(() -> AccountBusinessException.notFound()
                        .withClientDetails("reason", "Account not found for given identity")
                        .withClientDetails("actorType", identity.getActorType().name())
                        .withClientDetails("actorCode", identity.getActorCode().toString())
                );

        if (!account.getActorIdentity().sameAs(identity)) {
            throw AccountBusinessException.notFound()
                    .withClientDetails("reason", "Account not found for given identity")
                    .withClientDetails("actorType", identity.getActorType().name())
                    .withClientDetails("actorCode", identity.getActorCode().toString());
        }

        return account;
    }


    public PageResult<Account> getAll(AccountPageRequest request) {
        return accountRepository.findAll(request);
    }


    // ------------------------------- End Retrieval ------------------------------ //




    // ------------------------------Application Business Rule---------------------------- //



    private void ensureAtLeastAdminStillExists(Account target, Role role){
        ensureAtLeastAdminStillExists(target,List.of(role));
    }

    private void ensureAtLeastAdminStillExists(Account target, List<Role> newRoles) {

        boolean targetWasAdmin = target.hasRole(RoleDefinition.ADMIN.getName().value());

        boolean willStillBeAdmin = newRoles
                .stream()
                .anyMatch(r -> RoleDefinition.ADMIN.getName().value().equals(r.getName()));

        if (targetWasAdmin && !willStillBeAdmin) {

            long currentAdminCount = accountRepository.countByRoleName(
                    RoleDefinition.ADMIN.getName().value()
            );

            if (currentAdminCount <= 1) {
                throw AccountBusinessException.lastAdminRemovalNotAllowed();
            }
        }
    }

    // --------------------------- End Application Business Rule ------------------------- //


}
