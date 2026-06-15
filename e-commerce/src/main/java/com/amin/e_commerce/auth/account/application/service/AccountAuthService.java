package com.amin.e_commerce.auth.account.application.service;


import com.amin.e_commerce.auth.account.api.dto.*;
import com.amin.e_commerce.core.api.ActionResponse;

public interface AccountAuthService {


    AccountRegistrationResponse register(AccountRegistrationRequest request);

    AccountActivationResponse activate(AccountActivationRequest request);

    AccountLoginResponse login(AccountLoginRequest request);

    ActionResponse requestResetPassword(AccountResetPasswordRequest request);

    ActionResponse resetPassword(AccountConfirmResetPasswordRequest request);
}
