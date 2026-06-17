package com.amin.e_commerce.category.api.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CategoryResponse {
    private String code;
    private String name;
    private String description;
    private String status;
}
