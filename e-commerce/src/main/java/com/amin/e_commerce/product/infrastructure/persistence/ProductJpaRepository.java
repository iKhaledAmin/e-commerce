package com.amin.e_commerce.product.infrastructure.persistence;

import com.amin.e_commerce.core.persistence.BaseRepository;
import com.amin.e_commerce.product.domain.model.Product;
import com.amin.e_commerce.product.domain.model.ProductStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Optional;

public interface ProductJpaRepository extends BaseRepository<Product, Long> {
    Optional<Product> findByCode(String productCode);

    Optional<Product> findByCodeAndStatus(String productCode, ProductStatus productStatus);

    Page<Product> findAllByCategoryCode( String categoryCode,PageRequest pageRequest);

    Page<Product> findAllByStatus(PageRequest pageRequest, ProductStatus status);

    Page<Product> findAllByCategoryCodeAndStatus(String categoryCode, PageRequest pageRequest, ProductStatus status);


}
