package com.amin.e_commerce.category.api.dto;

import com.amin.e_commerce.category.domain.model.CategoryStatus;
import com.amin.e_commerce.category.domain.value.CategoryDescription;
import com.amin.e_commerce.category.domain.value.CategoryName;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryUpdateRequest {

    public static final String NAME_PATTERN = CategoryName.PATTERN;
    public static final int NAME_MAX_LENGTH = CategoryName.MAX_LENGTH;
    public static final int DESCRIPTION_MAX_LENGTH = CategoryDescription.MAX_LENGTH;


    @Pattern(regexp = NAME_PATTERN, message = "Category name format is invalid")
    @Size(max = NAME_MAX_LENGTH, message = "Category name is too long")
    @JsonProperty("name")
    private String name;

    @Size(max = DESCRIPTION_MAX_LENGTH, message = "Category description is too long")
    @JsonProperty("description")
    private String description;

    @JsonProperty("status")
    private CategoryStatus status;
}
