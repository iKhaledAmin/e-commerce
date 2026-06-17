package com.amin.e_commerce.category.application.service;

import com.amin.e_commerce.category.domain.model.Category;
import com.amin.e_commerce.category.domain.value.CategoryCode;
import com.amin.e_commerce.category.domain.value.CategoryName;

import java.util.Optional;

public interface CategoryQueryService {
    Optional<Category> getOptionalByCode(CategoryCode code);
    Category getByCode(CategoryCode code);

    boolean existsByName(CategoryName name);

}
