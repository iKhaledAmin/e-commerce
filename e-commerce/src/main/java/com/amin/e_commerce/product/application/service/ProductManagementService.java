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
    Product viewPurchasable(ProductCode code);

    PageResult<Product> list(CategoryCode categoryCode, ProductPageRequest request);
    PageResult<Product> listPurchasable(CategoryCode categoryCode, ProductPageRequest request);

    void connectStock(ProductCode productCode , String stockCode);

    void publish(ProductCode productCode);
    void unPublish(ProductCode productCode);

}
