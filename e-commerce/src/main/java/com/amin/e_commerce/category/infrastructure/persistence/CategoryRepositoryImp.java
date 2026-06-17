package com.amin.e_commerce.category.infrastructure.persistence;

import com.amin.e_commerce.category.api.dto.CategoryPageRequest;
import com.amin.e_commerce.category.domain.model.Category;
import com.amin.e_commerce.category.domain.repository.CategoryRepository;
import com.amin.e_commerce.core.pagination.PageResult;
import com.amin.e_commerce.core.pagination.PageResultFactory;
import com.amin.e_commerce.core.pagination.PageableFactory;
import lombok.AllArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class CategoryRepositoryImp implements CategoryRepository {
    private final CategoryJpaRepository categoryJpaRepository;

    @Override
    public Category save(Category category) {
        return categoryJpaRepository.save(category);
    }

    @Override
    public Optional<Category> findByCode(String code) {
        return categoryJpaRepository.findByCode(code);
    }

    @Override
    public PageResult<Category> findAll(CategoryPageRequest request) {
        Page<Category> page = categoryJpaRepository.findAll(
                PageableFactory.from(request)
        );

        return PageResultFactory.from(page);
    }

    @Override
    public boolean existsByName(String name) {
        return categoryJpaRepository.existsByName(name);
    }
}
