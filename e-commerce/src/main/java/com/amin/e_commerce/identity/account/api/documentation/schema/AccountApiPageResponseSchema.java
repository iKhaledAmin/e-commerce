package com.amin.e_commerce.identity.account.api.documentation.schema;

import com.amin.e_commerce.core.api.response.Meta;
import com.amin.e_commerce.core.api.response.PageInfoResponse;
import com.amin.e_commerce.identity.account.api.dto.AccountResponse;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(
        name = "AccountApiPageResponse"
)
public class AccountApiPageResponseSchema {

    @Schema
    public Meta meta;

    @Schema
    public List<AccountResponse> data;

    @Schema
    public PageInfoResponse pageInfo;
}