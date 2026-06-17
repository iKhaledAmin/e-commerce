package com.amin.e_commerce.category.domain.repository;

import com.amin.e_commerce.category.api.dto.CategoryPageRequest;
import com.amin.e_commerce.category.domain.model.Category;
import com.amin.e_commerce.core.pagination.PageResult;

import java.util.Optional;

public interface CategoryRepository {
    Category save(Category category);

    Optional<Category> findByCode(String code);

    PageResult<Category> findAll(CategoryPageRequest request);

    boolean existsByName(String name);
}
