package com.amin.e_commerce.category.api.dto;

import com.amin.e_commerce.category.domain.model.CategorySortField;
import com.amin.e_commerce.core.pagination.PageRequest;
import com.amin.e_commerce.core.pagination.SortField;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CategoryPageRequest extends PageRequest {
    private CategorySortField sortBy = CategorySortField.CREATED_AT;

    @Override
    public SortField getSortBy() {
        return sortBy;
    }
}
