package com.amin.e_commerce.identity.account.api.documentation.schema;

import com.amin.e_commerce.core.api.response.ApiActionResponse;
import com.amin.e_commerce.core.api.response.Meta;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
        name = "AccountApiActionResponse"
)
public class AccountApiActionResponseSchema {

    @Schema
    public Meta meta;

    @Schema
    public ApiActionResponse data;
}
