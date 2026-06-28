package com.amin.e_commerce.category.api.dto;

import com.amin.e_commerce.category.domain.model.CategoryStatus;
import com.amin.e_commerce.category.domain.value.CategoryDescription;
import com.amin.e_commerce.category.domain.value.CategoryName;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(
        name = "CategoryUpdateRequest",
        description = "Update category request"
)
public class CategoryUpdateRequest {


    @Schema(
            example = "Electronics",
            description = "Optional new name"
    )
    @Pattern(regexp = CategoryName.PATTERN, message = CategoryName.PATTERN_ERROR_MESSAGE)
    @Size(max = CategoryName.MAX_LENGTH, message = CategoryName.MAX_LENGTH_ERROR_MESSAGE)
    @JsonProperty("name")
    private String name;

    @Schema(
            example = "Electronic devices and accessories",
            description = "Optional new description"
    )
    @Size(max = CategoryDescription.MAX_LENGTH, message = CategoryDescription.MAX_LENGTH_ERROR_MESSAGE)
    @JsonProperty("description")
    private String description;

    @Schema(
            example = "ACTIVE",
            description = "Optional new status",
            allowableValues = {
                    "ACTIVE",
                    "INACTIVE"
            }
    )
    @JsonProperty("status")
    private CategoryStatus status;

    @Schema(
            description = "Optional new image",
            type = "string",
            format = "binary"
    )
    @JsonProperty("image")
    private MultipartFile image;
}
