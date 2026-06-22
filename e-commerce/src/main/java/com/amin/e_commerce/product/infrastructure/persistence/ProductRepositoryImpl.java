package com.amin.e_commerce.product.infrastructure.persistence;

import com.amin.e_commerce.core.api.pagination.PageResult;
import com.amin.e_commerce.core.api.pagination.PageResultFactory;
import com.amin.e_commerce.core.api.pagination.PageableFactory;
import com.amin.e_commerce.product.api.dto.ProductPageRequest;
import com.amin.e_commerce.product.domain.model.Product;
import com.amin.e_commerce.product.domain.model.ProductStatus;
import com.amin.e_commerce.product.domain.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {

    private final ProductJpaRepository jpaRepository;

    @Override
    public Product save(Product product) {
        return jpaRepository.save(product);
    }

    @Override
    public Optional<Product> findByCode(String productCode) {
        return jpaRepository.findByCode(productCode);
    }

    @Override
    public Optional<Product> findByCodeAndStatusActive(String productCode) {
        return jpaRepository.findByCodeAndStatus(productCode, ProductStatus.ACTIVE);
    }

    @Override
    public PageResult<Product> findAll(ProductPageRequest request) {
        Page<Product> page = jpaRepository.findAll(
                PageableFactory.from(request)
        );

        return PageResultFactory.from(page);
    }

    @Override
    public PageResult<Product> findAllByCategoryCode(String categoryCode, ProductPageRequest request) {
        Page<Product> page = jpaRepository.findAllByCategoryCode(
                categoryCode,
                PageableFactory.from(request)
        );

        return PageResultFactory.from(page);
    }

    @Override
    public PageResult<Product> findAllByStatusActive(ProductPageRequest request) {
        Page<Product> page = jpaRepository.findAllByStatus(
                PageableFactory.from(request),
                ProductStatus.ACTIVE
        );

        return PageResultFactory.from(page);
    }

    @Override
    public PageResult<Product> findAllByCategoryCodeAndStatusActive(String categoryCode, ProductPageRequest request) {
        Page<Product> page = jpaRepository.findAllByCategoryCodeAndStatus(
                categoryCode,
                PageableFactory.from(request),
                ProductStatus.ACTIVE
        );

        return PageResultFactory.from(page);
    }
}
