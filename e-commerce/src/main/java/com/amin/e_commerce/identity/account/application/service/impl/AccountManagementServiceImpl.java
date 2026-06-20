package com.amin.e_commerce.identity.account.application.service.impl;


import com.amin.e_commerce.core.logging.audit.BusinessEventLogger;
import com.amin.e_commerce.core.api.pagination.PageResult;
import com.amin.e_commerce.customer.application.sevice.CustomerService;
import com.amin.e_commerce.identity.account.api.dto.AccountCreateRequest;
import com.amin.e_commerce.identity.account.api.dto.AccountPageRequest;
import com.amin.e_commerce.identity.account.api.dto.AccountUpdateRequest;
import com.amin.e_commerce.identity.account.application.service.AccountManagementService;
import com.amin.e_commerce.identity.account.application.service.AccountQueryService;
import com.amin.e_commerce.identity.account.application.validation.AccountApplicationValidator;
import com.amin.e_commerce.identity.account.domain.command.AccountUpdateCommand;
import com.amin.e_commerce.identity.account.domain.model.Account;
import com.amin.e_commerce.identity.account.domain.model.AccountFactory;
import com.amin.e_commerce.identity.account.domain.repository.AccountRepository;
import com.amin.e_commerce.identity.account.domain.value.EncodedPassword;
import com.amin.e_commerce.identity.account.domain.value.RawPassword;
import com.amin.e_commerce.identity.core.model.Actor;
import com.amin.e_commerce.identity.core.model.ActorCode;
import com.amin.e_commerce.identity.core.provider.ActorProvider;
import com.amin.e_commerce.identity.role.application.service.RoleQueryService;
import com.amin.e_commerce.identity.role.domain.model.Role;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@AllArgsConstructor
@Service
public class AccountManagementServiceImpl implements AccountManagementService {

    private final AccountRepository accountRepository;
    private final AccountQueryService accountQueryService;
    private final AccountFactory accountFactory;
    private final RoleQueryService roleQueryService;
    private final CustomerService customerService;
    private final ActorProvider actorProvider;
    private final AccountApplicationValidator accountValidator;
    private final PasswordEncoder passwordEncoder;
    private final BusinessEventLogger businessEventLogger;


    @Transactional
    @Override
    public Account create(AccountCreateRequest request) {
        List<Role> roles = roleQueryService.getDefaultRoles();
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

        // Create customer (any account should be treated as a customer)
        customerService.create(saved.getId());

        return saved;
    }


    @Transactional
    @Override
    public Account update(ActorCode accountCode, AccountUpdateRequest request) {

        Account target = accountQueryService.getByAccountCode(accountCode);

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
    public Account activate(ActorCode accountCode) {
        Account target = accountQueryService.getByAccountCode(accountCode);

        // Domain logic
        target.activate();

        // Persist
        Account saved = accountRepository.save(target);

        // Log the business operation event
        businessEventLogger.accountActivated(
                saved.getAccountCode()
        );

        return saved;
    }

    @Transactional
    @Override
    public void resetPassword(ActorCode accountCode, RawPassword rawPassword) {

        Account target = accountQueryService.getByAccountCode(accountCode);

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


    @Override
    public void login(ActorCode accountCode) {
        Account account = accountQueryService.getByAccountCode(accountCode);
        account.login();
        accountRepository.save(account);
    }


    @Transactional(readOnly = true)
    public Account viewAccount(ActorCode accountCode) {

        Account account = accountQueryService.getByAccountCode(accountCode);

        businessEventLogger.accountViewed(
                account.getAccountCode()
        );

        return account;
    }

    @Transactional(readOnly = true)
    public Account viewMyAccount() {

        Actor actor = actorProvider.getCurrent();

        Account account = accountQueryService.getByIdentity(
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






}
