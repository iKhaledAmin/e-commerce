package com.amin.e_commerce.auth.account.application.service;


import com.amin.e_commerce.auth.account.api.dto.*;
import com.amin.e_commerce.auth.account.api.mapper.AccountAuthMapper;
import com.amin.e_commerce.auth.account.application.config.AuthenticationProperties;
import com.amin.e_commerce.auth.account.exception.AuthException;
import com.amin.e_commerce.core.api.response.ApiActionResponse;
import com.amin.e_commerce.core.exception.technical.TechnicalException;
import com.amin.e_commerce.core.logging.audit.BusinessEventLogger;
import com.amin.e_commerce.core.logging.audit.SecurityEventLogger;
import com.amin.e_commerce.core.logging.core.ActorLoggingContext;
import com.amin.e_commerce.email.application.port.in.EmailService;
import com.amin.e_commerce.email.domain.command.EmailCreateCommand;
import com.amin.e_commerce.core.exception.security.SecurityException;
import com.amin.e_commerce.email.domain.model.EmailTemplate;
import com.amin.e_commerce.email.infrastructure.config.EmailProperties;
import com.amin.e_commerce.identity.account.api.dto.AccountCreateRequest;
import com.amin.e_commerce.identity.account.application.service.AccountManagementService;
import com.amin.e_commerce.identity.account.application.service.AccountQueryService;
import com.amin.e_commerce.identity.account.domain.model.Account;
import com.amin.e_commerce.identity.account.domain.value.EmailAddress;
import com.amin.e_commerce.identity.account.domain.value.RawPassword;
import com.amin.e_commerce.identity.core.model.ActorCode;
import com.amin.e_commerce.security.jwt.JwtService;
import com.amin.e_commerce.security.principal.account.AccountPrincipal;
import com.amin.e_commerce.security.provider.AccountAuthenticationService;
import com.amin.e_commerce.verification.application.dto.VerificationResult;
import com.amin.e_commerce.verification.application.service.VerificationService;
import com.amin.e_commerce.verification.domain.model.TokenType;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;


import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.Set;


@Service
@RequiredArgsConstructor
public class AccountAuthServiceImpl implements AccountAuthService {


    private final VerificationService verificationService;
    private final AccountManagementService accountManagementService;
    private final AccountQueryService accountQueryService;
    private final EmailService emailService;
    private final JwtService jwtService;
    private final AccountAuthMapper accountAuthMapper;
    private final AuthenticationProperties authProperties;
    private final EmailProperties emailProperties;
    private final AccountAuthenticationService authenticationService;
    private final SecurityEventLogger securityEventLogger;
    private final BusinessEventLogger businessEventLogger;



    @Override
    @Transactional
    public AccountRegistrationResponse register(AccountRegistrationRequest request){

        AccountCreateRequest createRequest = accountAuthMapper.toCreateRequest(request);

        Account newAccount = accountManagementService.create(createRequest);

        String activationCode = verificationService.generateToken(
                TokenType.ACCOUNT_ACTIVATION,
                newAccount.getActorIdentity()
        );

        sendActivationEmail(newAccount, activationCode);

        businessEventLogger.accountRegistered(newAccount.getActorCode().toString());

        return accountAuthMapper.toRegistrationResponse(newAccount);
    }

    @Override
    @Transactional
    public AccountActivationResponse activate(AccountActivationRequest request){

        EmailAddress emailAddress = EmailAddress.of(request.getEmailAddress());

        Account account = accountQueryService.getOptionalByEmail(emailAddress)
                .orElseThrow(() -> AuthException.activationFailed()
                        .withDebugDetails("reason", "Account not found for the given email address")
                        .withDebugDetails("emailAddress", request.getEmailAddress())
                );

        VerificationResult result = verificationService.verifyToken(
                request.getCode(),
                account.getActorIdentity(),
                TokenType.ACCOUNT_ACTIVATION
        );

        ActorCode actorCode = result.target().getActorCode();

        Account activatedAccount = accountManagementService.activate(actorCode);

        return accountAuthMapper.toActivationResponse(activatedAccount);
    }


    @Override
    @Transactional
    public AccountLoginResponse login(AccountLoginRequest request) {

        try {

            AccountPrincipal principal = authenticationService.authenticate(
                    request.getUsername(),
                    request.getPassword()
            );

            accountManagementService.login(principal.getActorCode());

            String jwtToken = jwtService.generateToken(principal);

            // Set actor context
            ActorLoggingContext.put(principal);

            // Log login success
            securityEventLogger.loginSucceeded(principal);

            return accountAuthMapper.toLoginResponse(jwtToken, principal);

        } catch (SecurityException ex) {

            securityEventLogger.loginFailed(
                    request.getUsername(),
                    ex
            );

            throw ex;
        }
    }

    @Transactional
    @Override
    public ApiActionResponse requestResetPassword(AccountResetPasswordRequest request) {

        EmailAddress emailAddress = EmailAddress.of(request.getEmailAddress());

        Optional<Account> optionalAccount = accountQueryService.getOptionalByEmail(emailAddress);
        if (optionalAccount.isEmpty()) {
            return ApiActionResponse.builder()
                    .message("If an account exists for this emailAddress address,you will receive a reset password emailAddress.")
                    .build();

        }

        Account account = optionalAccount.get();

        String resetCode = verificationService.generateToken(
                TokenType.ACCOUNT_RESET_PASSWORD,
                account.getActorIdentity()
        );

        sendResetPasswordEmail(account, resetCode);

        businessEventLogger.passwordResetRequested(
                account.getAccountCode()
        );

        return ApiActionResponse.builder()
                .message("If an account exists for this email address,you will receive a reset password email.")
                .build();
    }

    @Override
    @Transactional
    public ApiActionResponse resetPassword(AccountConfirmResetPasswordRequest request) {

        EmailAddress emailAddress = EmailAddress.of(request.getEmailAddress());

        Account account = accountQueryService.getOptionalByEmail(emailAddress)
                .orElseThrow(() -> AuthException.resetPasswordFailed()
                        .withDebugDetails("reason", "Account not found for the given email address")
                        .withDebugDetails("emailAddress", request.getEmailAddress())
                );

        // Validate token
        VerificationResult result = verificationService.verifyToken(
                request.getCode(),
                account.getActorIdentity(),
                TokenType.ACCOUNT_RESET_PASSWORD
        );

        ActorCode actorCode = result.target().getActorCode();

        // Apply domain operation
        accountManagementService.resetPassword(
                actorCode,
                RawPassword.of(request.getPassword())
        );

        // Response
        return ApiActionResponse.builder()
                .message("Your password has been reset successfully.")
                .build();
    }


    // -------------------------------------- Helper methods --------------------------------------- //
    private void sendActivationEmail(Account account, String activationCode) {

        String activationUrl = authProperties.activation().frontendUrl();
        String sender = emailProperties.sender().from();
        String replyTo = emailProperties.sender().replyTo();

        Map<String, Object> variables = Map.of(
                "username", account.getUsername(),
                "activationCode", activationCode,
                "activationUrl", activationUrl
        );

        EmailCreateCommand command = EmailCreateCommand.of(
                sender,
                account.getEmailAddress(),
                replyTo,
                Set.of(),
                Set.of(),
                EmailTemplate.ACCOUNT_ACTIVATION.getSubject(),
                EmailTemplate.ACCOUNT_ACTIVATION.getName()
        );

        try {
            emailService.sendEmail(command, variables);
        } catch (TechnicalException e) {
            // Intentionally ignored.
            // Email delivery failure is non-blocking.
            // The Email module already logs the failure and schedules retries.
        }

    }

    private void sendResetPasswordEmail(Account account, String resetCode) {
        String sender = emailProperties.sender().from();
        String replyTo = emailProperties.sender().replyTo();

        Map<String, Object> variables = Map.of(
                "username", account.getUsername(),
                "resetCode", resetCode
        );

        EmailCreateCommand command = EmailCreateCommand.of(
                sender,
                account.getEmailAddress(),
                replyTo,
                Set.of(),
                Set.of(),
                EmailTemplate.ACCOUNT_RESET_PASSWORD.getSubject(),
                EmailTemplate.ACCOUNT_RESET_PASSWORD.getName()
        );

        try {
            emailService.sendEmail(command, variables);
        } catch (TechnicalException e) {
            // Intentionally ignored.
            // Email delivery failure is non-blocking.
            // The Email module already logs the failure and schedules retries.
        }

    }

    // -------------------------------------- End Helper methods ----------------------------------- //
}
