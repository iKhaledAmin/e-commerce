package com.amin.e_commerce.category.domain.model;

import com.amin.e_commerce.core.pagination.SortField;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum CategorySortField implements SortField {
    NAME("name"),
    CREATED_AT("createdAt");


    private final String field

            ;

    @Override
    public String getField() {
        return field;
    }
}
