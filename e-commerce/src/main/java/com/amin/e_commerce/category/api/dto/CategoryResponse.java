package com.amin.e_commerce.category.api.dto;

import lombok.Builder;
import lombok.Getter;
import io.swagger.v3.oas.annotations.media.Schema;


@Getter
@Builder
@Schema(
        name = "CategoryResponse",
        description = "Category details"
)
public class CategoryResponse {
    @Schema(example = "CAT-1A57S")
    private String code;

    @Schema(example = "Electronics")
    private String name;

    @Schema(example = "Electronic devices and accessories")
    private String description;

    @Schema(example = "ACTIVE")
    private String status;
}
