package com.amin.e_commerce.category.infrastructure.persistence;

import com.amin.e_commerce.category.domain.model.Category;
import com.amin.e_commerce.core.persistence.BaseRepository;

import java.util.Optional;

public interface CategoryJpaRepository extends BaseRepository<Category, Long> {
    Optional<Category> findByCode(String code);

    boolean existsByName(String name);
}
