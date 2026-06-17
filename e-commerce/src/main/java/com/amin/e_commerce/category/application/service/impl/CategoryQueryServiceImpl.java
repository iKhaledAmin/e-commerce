package com.amin.e_commerce.category.application.service.impl;

import com.amin.e_commerce.category.application.service.CategoryQueryService;
import com.amin.e_commerce.category.domain.model.Category;
import com.amin.e_commerce.category.domain.repository.CategoryRepository;
import com.amin.e_commerce.category.domain.value.CategoryCode;
import com.amin.e_commerce.category.domain.value.CategoryName;
import com.amin.e_commerce.category.exception.CategoryBusinessException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class CategoryQueryServiceImpl implements CategoryQueryService {
    private final CategoryRepository categoryRepository;

    @Override
    public Optional<Category> getOptionalByCode(CategoryCode code) {
        return categoryRepository.findByCode(code.toString());
    }

    @Override
    public Category getByCode(CategoryCode code) {
        return getOptionalByCode(code)
                .orElseThrow(() -> CategoryBusinessException.notFound()
                        .withClientDetails("reason", "Category not found")
                        .withDebugDetails("code", code.toString())
                );
    }

    @Override
    public boolean existsByName(CategoryName name) {
        return categoryRepository.existsByName(name.toString());
    }
}
