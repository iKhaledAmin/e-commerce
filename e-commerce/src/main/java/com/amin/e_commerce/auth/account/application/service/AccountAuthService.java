package com.amin.e_commerce.auth.account.application.service;

import com.amin.e_commerce.auth.account.api.dto.*;
import com.amin.e_commerce.core.api.response.ApiActionResponse;

public interface AccountAuthService {


    AccountRegistrationResponse register(AccountRegistrationRequest request);

    AccountActivationResponse activate(AccountActivationRequest request);

    AccountLoginResponse login(AccountLoginRequest request);

    ApiActionResponse requestResetPassword(AccountResetPasswordRequest request);

    ApiActionResponse resetPassword(AccountConfirmResetPasswordRequest request);
}
