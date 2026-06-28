package com.amin.e_commerce.category.api.dto;

import com.amin.e_commerce.category.domain.value.CategoryDescription;
import com.amin.e_commerce.category.domain.value.CategoryName;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
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
            description = "Mandatory name",
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
            description = "Optional description",
            nullable = true
    )
    @Size(max = CategoryDescription.MAX_LENGTH, message = CategoryDescription.MAX_LENGTH_ERROR_MESSAGE)
    @JsonProperty("description")
    private String description;

    @Schema(
            description = "Mandatory image file",
            requiredMode = Schema.RequiredMode.REQUIRED,
            type = "string",
            format = "binary"
    )
    @JsonProperty("image")
    private MultipartFile image;
}
