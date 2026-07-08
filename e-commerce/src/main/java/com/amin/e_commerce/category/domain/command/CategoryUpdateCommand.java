package com.amin.e_commerce.category.domain.command;

import com.amin.e_commerce.category.api.dto.CategoryUpdateRequest;
import com.amin.e_commerce.category.domain.model.CategoryStatus;
import com.amin.e_commerce.category.domain.value.CategoryDescription;
import com.amin.e_commerce.category.domain.value.CategoryName;

import java.util.Optional;

public record CategoryUpdateCommand(
        Optional<CategoryName> name,
        Optional<CategoryDescription> description,
        Optional<CategoryStatus> status
) {

    public static CategoryUpdateCommand of(
            String name,
            String description,
            CategoryStatus status
    ){
        return new CategoryUpdateCommand(
                Optional.ofNullable(name).map(CategoryName::of),
                Optional.ofNullable(description).map(CategoryDescription::of),
                Optional.ofNullable(status)
        );
    }

    public static CategoryUpdateCommand of(CategoryUpdateRequest request){
        return of(
                request.getName(),
                request.getDescription(),
                request.getStatus()
        );
    }
}
