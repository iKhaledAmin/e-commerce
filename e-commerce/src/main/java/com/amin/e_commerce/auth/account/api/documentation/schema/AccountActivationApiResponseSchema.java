package com.amin.e_commerce.auth.account.api.documentation.schema;

import com.amin.e_commerce.auth.account.api.dto.AccountActivationResponse;
import com.amin.e_commerce.core.api.response.Meta;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
        name = "AccountActivationApiResponse"
)
public class AccountActivationApiResponseSchema {

    @Schema
    public Meta meta;

    @Schema
    public AccountActivationResponse data;
}