package com.amin.e_commerce.category.api.documentation.schema;

import com.amin.e_commerce.category.api.dto.CategoryResponse;
import com.amin.e_commerce.core.api.response.Meta;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
        name = "CategoryApiResponse"
)
public class CategoryApiResponseSchema {

    @Schema
    public Meta meta;

    @Schema
    public CategoryResponse data;
}