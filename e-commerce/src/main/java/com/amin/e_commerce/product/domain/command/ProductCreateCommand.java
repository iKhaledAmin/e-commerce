package com.amin.e_commerce.product.domain.command;

import com.amin.e_commerce.category.domain.model.Category;
import com.amin.e_commerce.product.domain.value.ProductDescription;
import com.amin.e_commerce.product.domain.value.ProductName;
import com.amin.e_commerce.product.domain.value.ProductPrice;

import java.math.BigDecimal;

public record ProductCreateCommand(
        ProductName name,
        ProductDescription description,
        ProductPrice price,
        Category category
) {

    public static ProductCreateCommand of(
            String name,
            String description,
            BigDecimal price,
            Category category
    ) {

        return new ProductCreateCommand(
                ProductName.of(name),
                ProductDescription.of(description),
                ProductPrice.of(price),
                category
        );
    }
}