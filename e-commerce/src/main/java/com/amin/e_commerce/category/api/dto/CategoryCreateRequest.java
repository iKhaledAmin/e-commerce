package com.amin.e_commerce.category.api.dto;

import com.amin.e_commerce.category.domain.value.CategoryDescription;
import com.amin.e_commerce.category.domain.value.CategoryName;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(
        name = "CategoryCreateRequest",
        description = "Create category request"
)
public class CategoryCreateRequest {


    @Schema(
            example = "Electronics",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotEmpty(message = CategoryName.NULL_ERROR_MESSAGE)
    @NotBlank(message = CategoryName.NULL_ERROR_MESSAGE)
    @Pattern(regexp = CategoryName.PATTERN, message = CategoryName.PATTERN_ERROR_MESSAGE)
    @Size(max = CategoryName.MAX_LENGTH, message = CategoryName.MAX_LENGTH_ERROR_MESSAGE)
    @JsonProperty("name")
    private String name;


    @Schema(
            example = "Electronic devices and accessories",
            nullable = true
    )
    @Size(max = CategoryDescription.MAX_LENGTH, message = CategoryDescription.MAX_LENGTH_ERROR_MESSAGE)
    @JsonProperty("description")
    private String description;
}
