package com.amin.e_commerce.category.api.documentation.schema;

import com.amin.e_commerce.core.api.response.ApiActionResponse;
import com.amin.e_commerce.core.api.response.Meta;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
        name = "CategoryApiActionResponse"
)
public class CategoryApiActionResponseSchema {

    @Schema
    public Meta meta;

    @Schema
    public ApiActionResponse data;
}
