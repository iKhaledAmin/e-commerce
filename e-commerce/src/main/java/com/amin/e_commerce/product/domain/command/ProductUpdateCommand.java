package com.amin.e_commerce.product.domain.command;

import com.amin.e_commerce.category.domain.model.Category;
import com.amin.e_commerce.product.domain.model.ProductStatus;
import com.amin.e_commerce.product.domain.value.ProductDescription;
import com.amin.e_commerce.product.domain.value.ProductName;
import com.amin.e_commerce.product.domain.value.ProductPrice;

import java.math.BigDecimal;
import java.util.Optional;

public record ProductUpdateCommand(
        Optional<ProductName> name,
        Optional<ProductDescription> description,
        Optional<ProductPrice> price,
        Optional<ProductStatus> status,
        Optional<Category> category
) {

    public static ProductUpdateCommand of(
            String name,
            String description,
            BigDecimal price,
            ProductStatus status,
            Category category
    ) {

        return new ProductUpdateCommand(
                Optional.ofNullable(name).map(ProductName::of),
                Optional.ofNullable(description).map(ProductDescription::of),
                Optional.ofNullable(price).map(ProductPrice::of),
                Optional.ofNullable(status),
                Optional.ofNullable(category)
        );
    }
}