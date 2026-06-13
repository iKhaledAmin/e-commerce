package com.amin.e_commerce.identity.account.api.controller;


import com.amin.e_commerce.core.api.ApiPageResponse;
import com.amin.e_commerce.core.api.ApiResponse;
import com.amin.e_commerce.core.api.ApiResponseFactory;
import com.amin.e_commerce.core.pagination.PageMapper;
import com.amin.e_commerce.core.pagination.PageResult;
import com.amin.e_commerce.identity.account.api.dto.*;
import com.amin.e_commerce.identity.account.api.mapper.AccountAdminMapper;
import com.amin.e_commerce.identity.account.api.mapper.AccountMapper;
import com.amin.e_commerce.identity.account.application.service.AccountService;
import com.amin.e_commerce.identity.account.domain.model.Account;
import com.amin.e_commerce.identity.core.model.Actor;
import com.amin.e_commerce.identity.core.model.ActorCode;
import com.amin.e_commerce.identity.core.provider.ActorProvider;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("accounts")
@RequiredArgsConstructor
@Tag(name = "Account Management")
public class AccountController {
    private final AccountService accountService;
    private final AccountMapper accountMapper;
    private final AccountAdminMapper accountAdminMapper;
    private final ActorProvider actorProvider;


    @PreAuthorize("hasAuthority('account_create')")
    @PostMapping
    public ResponseEntity<ApiResponse<AccountAdminResponse>> createAccount(@Valid @RequestBody AccountCreateRequest request) {

        Account newAccount = accountService.create(request);

        AccountAdminResponse response = accountAdminMapper.toResponse(newAccount);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponseFactory.success(response));
    }

    @PreAuthorize("hasAuthority('account_update_self')")
    @PatchMapping("/me")
    public ResponseEntity<ApiResponse<AccountResponse>> updateMyAccount(
            @Valid @RequestBody AccountUpdateRequest request) {

        Actor authaticatedActor = actorProvider.getCurrent();
        ActorCode accountCode = authaticatedActor.getActorIdentity().getActorCode();

        Account updatedAccount = accountService.update(accountCode,request);

        AccountResponse response = accountMapper.toResponse(updatedAccount);
        return ResponseEntity.ok(
                ApiResponseFactory.success(response)
        );
    }

    @PreAuthorize("hasAuthority('account_update')")
    @PatchMapping("/{accountCode}")
    public ResponseEntity<ApiResponse<AccountAdminResponse>> updateAccount(
            @PathVariable String accountCode,
            @Valid @RequestBody AccountUpdateRequest request) {

        Account updatedAccount = accountService.update(
                ActorCode.of(accountCode),
                request
        );

        AccountAdminResponse response = accountAdminMapper.toResponse(updatedAccount);
        return ResponseEntity.ok(
                ApiResponseFactory.success(response)
        );
    }

    @PreAuthorize("hasAuthority('account_read_self')")
    @GetMapping("/me")
    public ResponseEntity<ApiResponse<AccountResponse>> viewMyAccount() {


        Account account = accountService.viewMyAccount();

        AccountResponse response = accountMapper.toResponse(account);
        return ResponseEntity.ok(
                ApiResponseFactory.success(response)
        );
    }


    @PreAuthorize("hasAuthority('account_read')")
    @GetMapping("/{accountCode}")
    public ResponseEntity<ApiResponse<AccountAdminResponse>> viewAccount(@PathVariable String accountCode) {

        Account account = accountService.viewAccount(
                ActorCode.of(accountCode)
        );

        AccountAdminResponse response = accountAdminMapper.toResponse(account);
        return ResponseEntity.ok(
                ApiResponseFactory.success(response)
        );
    }

    @GetMapping
    @PreAuthorize("hasAuthority('account_read')")
    public ResponseEntity<ApiPageResponse<AccountAdminResponse>> listAccounts(@Valid AccountPageRequest pageRequest) {

        PageResult<Account> accounts = accountService.listAccounts(pageRequest);

        PageResult<AccountAdminResponse> response = PageMapper.map(accounts, accountAdminMapper::toResponse);

        return ResponseEntity.ok(
                ApiResponseFactory.page(response)
        );
    }



}
