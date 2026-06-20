package com.amin.e_commerce.category.api.documentation.schema;

import com.amin.e_commerce.core.api.response.Meta;
import com.amin.e_commerce.core.api.response.PageInfoResponse;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(
        name = "CategoryApiPageResponse"
)
public class CategoryApiPageResponseSchema {

    @Schema
    public Meta meta;

    @Schema
    public List<CategoryResponseSchema> data;

    @Schema
    public PageInfoResponse pageInfo;
}