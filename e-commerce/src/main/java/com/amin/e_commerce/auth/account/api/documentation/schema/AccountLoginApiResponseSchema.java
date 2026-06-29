package com.amin.e_commerce.auth.account.api.documentation.schema;

import com.amin.e_commerce.auth.account.api.dto.AccountLoginResponse;
import com.amin.e_commerce.core.api.response.Meta;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
        name = "AccountLoginApiResponse"
)
public class AccountLoginApiResponseSchema {

    @Schema
    public Meta meta;

    @Schema
    public AccountLoginResponse data;
}