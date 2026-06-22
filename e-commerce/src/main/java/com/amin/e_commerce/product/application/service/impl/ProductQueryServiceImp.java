package com.amin.e_commerce.product.application.service.impl;

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
}
