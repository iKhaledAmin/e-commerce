package com.amin.e_commerce.category.domain.command;

import com.amin.e_commerce.category.api.dto.CategoryCreateRequest;
import com.amin.e_commerce.category.domain.value.CategoryDescription;
import com.amin.e_commerce.category.domain.value.CategoryName;


public record CategoryCreateCommand(
        CategoryName name,
        CategoryDescription description
) {

    public static CategoryCreateCommand of(String name, String description) {
        return new CategoryCreateCommand(
                CategoryName.of(name),
                CategoryDescription.of(description)
        );
    }

    public static CategoryCreateCommand of(CategoryCreateRequest request) {
        return of(
                request.getName(),
                request.getDescription()
        );
    }
}
