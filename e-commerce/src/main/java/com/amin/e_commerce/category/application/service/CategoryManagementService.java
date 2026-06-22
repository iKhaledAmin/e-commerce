package com.amin.e_commerce.category.application.service;

import com.amin.e_commerce.category.api.dto.CategoryCreateRequest;
import com.amin.e_commerce.category.api.dto.CategoryPageRequest;
import com.amin.e_commerce.category.api.dto.CategoryUpdateRequest;
import com.amin.e_commerce.category.domain.model.Category;
import com.amin.e_commerce.category.domain.value.CategoryCode;
import com.amin.e_commerce.core.api.pagination.PageResult;

public interface CategoryManagementService {
    Category create(CategoryCreateRequest request);
    Category update(CategoryCode code, CategoryUpdateRequest request);
    void delete(CategoryCode code);

    Category view(CategoryCode code);

    PageResult<Category> list(CategoryPageRequest request);
}
