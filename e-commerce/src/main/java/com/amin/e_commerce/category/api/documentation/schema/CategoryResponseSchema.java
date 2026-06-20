package com.amin.e_commerce.category.api.documentation.schema;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
        name = "CategoryResponse"
)
public class CategoryResponseSchema {

    @Schema(example = "CAT-001")
    public String code;

    @Schema(example = "Electronics")
    public String name;

    @Schema(example = "Electronic products")
    public String description;

    @Schema(example = "ACTIVE")
    public String status;
}