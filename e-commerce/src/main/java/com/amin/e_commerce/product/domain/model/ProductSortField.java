package com.amin.e_commerce.product.domain.model;

import com.amin.e_commerce.product.exception.ProductValidationException;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProductSortField {
    NAME("name"),
    CREATED_AT("createdAt")
            ;

    private final String field;


    public static String getDefault() {
        return NAME.getField();
    }

    public static String getFieldFrom(String queryParam) {
        try {
            return ProductSortField.valueOf(queryParam).getField();
        } catch (IllegalArgumentException e) {
            throw ProductValidationException.invalidSortField()
                    .withDebugDetails("sortField" , queryParam);
        }
    }
}
