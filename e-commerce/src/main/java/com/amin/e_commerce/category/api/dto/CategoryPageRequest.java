package com.amin.e_commerce.category.api.dto;

import com.amin.e_commerce.category.domain.model.CategorySortField;
import com.amin.e_commerce.core.api.pagination.PageRequest;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Schema(
        name = "CategoryPageRequest",
        description = "Category page request"
)
public class CategoryPageRequest extends PageRequest {

    @Schema(
            description = "Category sorting field",
            allowableValues = {
                    "NAME",
                    "CREATED_AT"
            },
            example = "NAME"
    )
    private String sortBy = CategorySortField.getDefault();



    @Override
    public String getSortBy() {
        return CategorySortField.getFieldFrom(sortBy);
    }

}
