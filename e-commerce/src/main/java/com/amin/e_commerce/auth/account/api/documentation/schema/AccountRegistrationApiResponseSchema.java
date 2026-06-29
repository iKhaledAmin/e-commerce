package com.amin.e_commerce.auth.account.api.documentation.schema;

import com.amin.e_commerce.auth.account.api.dto.AccountRegistrationResponse;
import com.amin.e_commerce.core.api.response.Meta;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
        name = "AccountRegistrationApiResponse"
)
public class AccountRegistrationApiResponseSchema {

    @Schema
    public Meta meta;

    @Schema
    public AccountRegistrationResponse data;
}