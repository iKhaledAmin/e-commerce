package com.amin.e_commerce.identity.account.api.documentation.schema;

import com.amin.e_commerce.core.api.response.Meta;
import com.amin.e_commerce.identity.account.api.dto.AccountResponse;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
        name = "AccountApiResponse"
)
public class AccountApiResponseSchema {

    @Schema
    public Meta meta;

    @Schema
    public AccountResponse data;
}