package com.amin.e_commerce.product.infrastructure.persistence;

import com.amin.e_commerce.core.persistence.BaseRepository;
import com.amin.e_commerce.product.domain.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Optional;

public interface ProductJpaRepository extends BaseRepository<Product, Long> {
    Optional<Product> findByCode(String code);

    Page<Product> findAllByCategoryCode( String categoryCode,PageRequest pageRequest);
}
