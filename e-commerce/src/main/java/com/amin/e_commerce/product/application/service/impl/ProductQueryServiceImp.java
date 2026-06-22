package com.amin.e_commerce.product.application.service.impl;

import com.amin.e_commerce.category.domain.value.CategoryCode;
import com.amin.e_commerce.core.api.pagination.PageResult;
import com.amin.e_commerce.product.api.dto.ProductPageRequest;
import com.amin.e_commerce.product.application.service.ProductQueryService;
import com.amin.e_commerce.product.domain.model.Product;
import com.amin.e_commerce.product.domain.repository.ProductRepository;
import com.amin.e_commerce.product.domain.value.ProductCode;
import com.amin.e_commerce.product.exception.ProductBusinessException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class ProductQueryServiceImp implements ProductQueryService {
    private final ProductRepository productRepository;

    @Override
    public Optional<Product> getOptionalByCode(ProductCode code) {
        return productRepository.findByCode(code.toString());
    }

    @Override
    public Product getByCode(ProductCode code) {
        return getOptionalByCode(code)
                .orElseThrow(() -> ProductBusinessException.notFound()
                        .withDebugDetails("reason", "Product not found")
                        .withDebugDetails("code", code.toString())
                );
    }

    @Override
    public Optional<Product> getOptionalPurchasableByCode(ProductCode code) {
        return productRepository.findByCodeAndStatusActive(code.toString());
    }

    @Override
    public Product getPurchasableByCode(ProductCode code) {
        return getOptionalPurchasableByCode(code)
                .orElseThrow(() -> ProductBusinessException.notFound()
                        .withDebugDetails("reason", "Product not found")
                        .withDebugDetails("code", code.toString())
                );
    }

    @Override
    public PageResult<Product> getAll(ProductPageRequest request) {
        return productRepository.findAll(request);
    }

    @Override
    public PageResult<Product> getAllByCategoryCode(CategoryCode categoryCode, ProductPageRequest request) {
        return productRepository.findAllByCategoryCode(categoryCode.toString(), request);
    }

    @Override
    public PageResult<Product> getAllPurchasable(ProductPageRequest request) {
        return productRepository.findAllByStatusActive(request);
    }

    @Override
    public PageResult<Product> getAllPurchasableByCategoryCode(CategoryCode categoryCode, ProductPageRequest request) {
        return productRepository.findAllByCategoryCodeAndStatusActive(categoryCode.toString(), request);
    }
}
