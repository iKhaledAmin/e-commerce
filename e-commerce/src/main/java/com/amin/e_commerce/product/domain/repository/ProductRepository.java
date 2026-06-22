package com.amin.e_commerce.product.domain.repository;

import com.amin.e_commerce.core.api.pagination.PageResult;
import com.amin.e_commerce.product.api.dto.ProductPageRequest;
import com.amin.e_commerce.product.domain.model.Product;

import java.util.Optional;

public interface ProductRepository {
    Product save(Product product);

    Optional<Product> findByCode(String productCode);
    Optional<Product> findByCodeAndStatusActive(String productCode);

    PageResult<Product> findAll(ProductPageRequest request);
    PageResult<Product> findAllByCategoryCode(String categoryCode, ProductPageRequest request);

    PageResult<Product> findAllByStatusActive(ProductPageRequest request);
    PageResult<Product> findAllByCategoryCodeAndStatusActive(String categoryCode, ProductPageRequest request);
}
