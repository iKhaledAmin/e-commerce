package com.amin.e_commerce.auth.account.api.controller;

import com.amin.e_commerce.auth.account.api.dto.*;
import com.amin.e_commerce.auth.account.application.service.AccountAuthService;
import com.amin.e_commerce.core.api.response.ApiActionResponse;
import com.amin.e_commerce.core.api.response.ApiResponse;
import com.amin.e_commerce.core.api.response.ApiResponseFactory;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth/account")
@RequiredArgsConstructor
@Tag(name = "Authentication")
public class AccountAuthController {
    private final AccountAuthService authService;


    @PostMapping("/register")
    public ResponseEntity<ApiResponse<AccountRegistrationResponse>> register(@RequestBody @Valid AccountRegistrationRequest request){

        AccountRegistrationResponse response = authService.register(request);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponseFactory.success(response));
    }


    @PostMapping("/activate")
    public ResponseEntity<ApiResponse<AccountActivationResponse>> activate(@RequestBody @Valid AccountActivationRequest request) {

        AccountActivationResponse response = authService.activate(request);
        return ResponseEntity.ok(
                ApiResponseFactory.success(response)
        );
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<AccountLoginResponse>> login(@RequestBody @Valid AccountLoginRequest request) {

        AccountLoginResponse response = authService.login(request);
        return ResponseEntity.ok(
                ApiResponseFactory.success(response)
        );
    }

    @PostMapping("/reset-password-request")
    public ResponseEntity<ApiResponse<ApiActionResponse>> requestResetPassword(@RequestBody @Valid AccountResetPasswordRequest request) {

        ApiActionResponse response = authService.requestResetPassword(request);
        return ResponseEntity.ok(
                ApiResponseFactory.success(response)
        );
    }

    @PostMapping("/reset-password-confirm")
    public ResponseEntity<ApiResponse<ApiActionResponse>> confirmResetPassword(
            @RequestBody @Valid AccountConfirmResetPasswordRequest request
    ) {
        ApiActionResponse response = authService.resetPassword(request);
        return ResponseEntity.ok(
                ApiResponseFactory.success(response)
        );
    }



}
