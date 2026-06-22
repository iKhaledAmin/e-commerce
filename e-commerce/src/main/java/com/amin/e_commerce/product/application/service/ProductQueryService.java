package com.amin.e_commerce.product.application.service;

import com.amin.e_commerce.product.domain.model.Product;
import com.amin.e_commerce.product.domain.value.ProductCode;

import java.util.Optional;

public interface ProductQueryService {
    Optional<Product> getOptionalByCode(ProductCode code);
    Product getByCode(ProductCode code);
}
