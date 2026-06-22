package com.amin.e_commerce.product.application.service;

import com.amin.e_commerce.category.domain.value.CategoryCode;
import com.amin.e_commerce.core.api.pagination.PageResult;
import com.amin.e_commerce.product.api.dto.ProductCreateRequest;
import com.amin.e_commerce.product.api.dto.ProductPageRequest;
import com.amin.e_commerce.product.api.dto.ProductUpdateRequest;
import com.amin.e_commerce.product.domain.model.Product;
import com.amin.e_commerce.product.domain.value.ProductCode;

public interface ProductManagementService {

    Product create(ProductCreateRequest request);
    Product update(ProductCode code, ProductUpdateRequest request);
    void delete(ProductCode code);

    Product view(ProductCode code);

    PageResult<Product> list(ProductPageRequest request);
    PageResult<Product> listByCategoryCode(CategoryCode categoryCode, ProductPageRequest request);
}
