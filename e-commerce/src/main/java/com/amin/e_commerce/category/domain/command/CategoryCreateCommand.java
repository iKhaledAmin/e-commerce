package com.amin.e_commerce.category.domain.command;

import com.amin.e_commerce.category.domain.value.CategoryCode;
import com.amin.e_commerce.category.domain.value.CategoryDescription;
import com.amin.e_commerce.category.domain.value.CategoryName;


public record CategoryCreateCommand(
        CategoryCode code,
        CategoryName name,
        CategoryDescription description
) {

    public static CategoryCreateCommand of(String code ,String name, String description) {
        return new CategoryCreateCommand(
                CategoryCode.of(code),
                CategoryName.of(name),
                CategoryDescription.of(description)
        );
    }

}
