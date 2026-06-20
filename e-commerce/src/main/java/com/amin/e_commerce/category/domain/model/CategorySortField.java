package com.amin.e_commerce.category.domain.model;

import com.amin.e_commerce.category.exception.CategoryValidationException;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CategorySortField {
    NAME("name"),
    CREATED_AT("createdAt")
    ;

    private final String field;



    public static String getDefault() {
        return NAME.getField();
    }

    public static String getFieldFrom(String queryParam) {
        try {
            return CategorySortField.valueOf(queryParam).getField();
        } catch (IllegalArgumentException e) {
            throw CategoryValidationException.invalidSortField()
                    .withDebugDetails("sortField" , queryParam);
        }
    }



}
