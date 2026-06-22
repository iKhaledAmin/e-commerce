package com.amin.e_commerce.product.application.service;

import com.amin.e_commerce.category.domain.value.CategoryCode;
import com.amin.e_commerce.core.api.pagination.PageResult;
import com.amin.e_commerce.product.api.dto.ProductPageRequest;
import com.amin.e_commerce.product.domain.model.Product;
import com.amin.e_commerce.product.domain.value.ProductCode;

import java.util.Optional;

public interface ProductQueryService {
    Optional<Product> getOptionalByCode(ProductCode code);
    Product getByCode(ProductCode code);

    Optional<Product> getOptionalPurchasableByCode(ProductCode code);
    Product getPurchasableByCode(ProductCode code);

    PageResult<Product> getAll(ProductPageRequest request);
    PageResult<Product> getAllByCategoryCode(CategoryCode categoryCode, ProductPageRequest request);

    PageResult<Product> getAllPurchasable(ProductPageRequest request);
    PageResult<Product> getAllPurchasableByCategoryCode(CategoryCode categoryCode, ProductPageRequest request);
}
