package com.amin.e_commerce.identity.account.application.service.impl;

import com.amin.e_commerce.core.pagination.PageResult;
import com.amin.e_commerce.identity.account.api.dto.AccountPageRequest;
import com.amin.e_commerce.identity.account.application.service.AccountQueryService;
import com.amin.e_commerce.identity.account.domain.model.Account;
import com.amin.e_commerce.identity.account.domain.repository.AccountRepository;
import com.amin.e_commerce.identity.account.domain.value.EmailAddress;
import com.amin.e_commerce.identity.account.domain.value.Username;
import com.amin.e_commerce.identity.account.exception.AccountBusinessException;
import com.amin.e_commerce.identity.account.exception.AccountTechnicalException;
import com.amin.e_commerce.identity.core.model.ActorCode;
import com.amin.e_commerce.identity.core.model.ActorIdentity;
import com.amin.e_commerce.identity.role.domain.value.RoleName;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AccountQueryServiceImpl implements AccountQueryService {
    private final AccountRepository accountRepository;

    @Override
    public Optional<Account> getOptionalByEmail(EmailAddress emailAddress) {
        return accountRepository.findByEmail(emailAddress.toString());
    }

    @Override
    public Account getByEmail(EmailAddress emailAddress) {
        return getOptionalByEmail(emailAddress).orElseThrow(() -> AccountBusinessException.notFound()
                .withClientDetails("reason", "Account not found for given email")
                .withDebugDetails("email", emailAddress)
        );
    }

    @Override
    public Optional<Account> getOptionalByUsername(Username username) {
        return accountRepository.findByUsername(username.toString());
    }

    public Optional<Account> getOptionalByAccountCode(ActorCode accountCode) {
        return accountRepository.findByAccountCode(accountCode.toString());
    }

    public Account getByAccountCode(ActorCode accountCode){
        return getOptionalByAccountCode(accountCode).orElseThrow(() -> AccountBusinessException.notFound()
                .withClientDetails("reason", "Account not found for given code")
                .withDebugDetails("accountCode", accountCode.toString())
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

    @Override
    public List<Account> getAllByRoleName(RoleName roleName) {
        return accountRepository.findAllByRoleName(
                roleName.toString()
        );
    }

    @Override
    public boolean existsByUsername(Username username) {
        return accountRepository.existsByUsername(username.toString());
    }


}
