package com.amin.e_commerce.category.api.controller;

import com.amin.e_commerce.category.api.documentation.annotations.*;
import com.amin.e_commerce.category.api.dto.CategoryCreateRequest;
import com.amin.e_commerce.category.api.dto.CategoryPageRequest;
import com.amin.e_commerce.category.api.dto.CategoryResponse;
import com.amin.e_commerce.category.api.dto.CategoryUpdateRequest;
import com.amin.e_commerce.category.api.mapper.CategoryMapper;
import com.amin.e_commerce.category.application.service.CategoryManagementService;
import com.amin.e_commerce.category.domain.model.Category;
import com.amin.e_commerce.category.domain.value.CategoryCode;
import com.amin.e_commerce.core.api.response.ApiActionResponse;
import com.amin.e_commerce.core.api.response.ApiPageResponse;
import com.amin.e_commerce.core.api.response.ApiResponse;
import com.amin.e_commerce.core.api.response.ApiResponseFactory;
import com.amin.e_commerce.core.api.pagination.PageMapper;
import com.amin.e_commerce.core.api.pagination.PageResult;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import org.springdoc.core.annotations.ParameterObject;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;



@Tag(
        name = "Category Management",
        description = """
                APIs for managing product categories.

                Features:
                - Create category
                - Update category
                - Delete category
                - View category
                - List categories
                """
)
@RestController
@RequiredArgsConstructor
@RequestMapping("categories")
public class CategoryController {
    private final CategoryManagementService categoryManagementService;
    private final CategoryMapper categoryMapper;



    @PostMapping
    @CategoryCreateApiDocs
    @PreAuthorize("hasAuthority('category_create')")
    public ResponseEntity<ApiResponse<CategoryResponse>> create(@Valid @RequestBody CategoryCreateRequest request){

        Category created = categoryManagementService.create(request);
        CategoryResponse response = categoryMapper.toResponse(created);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponseFactory.success(response));
    }



    @CategoryUpdateApiDocs
    @PatchMapping("/{code}")
    @PreAuthorize("hasAuthority('category_update')")
    public ResponseEntity<ApiResponse<CategoryResponse>> update(
            @Parameter(
                    description = "Category unique business identifier",
                    example = "CAT-001",
                    required = true
            )
            @PathVariable
            String code,

            @Valid
            @RequestBody
            CategoryUpdateRequest request) {

        Category updated = categoryManagementService.update(
                CategoryCode.of(code), request
        );

        CategoryResponse response = categoryMapper.toResponse(updated);

        return ResponseEntity.ok(
                ApiResponseFactory.success(response)
        );
    }




    @CategoryDeleteApiDocs
    @DeleteMapping("/{code}")
    @PreAuthorize("hasAuthority('category_delete')")
    public ResponseEntity<ApiResponse<ApiActionResponse>> delete(
            @Parameter(
                    description = "Category unique business identifier",
                    example = "CAT-001",
                    required = true
            )
            @PathVariable String code) {

        categoryManagementService.delete(
                CategoryCode.of(code)
        );

        return ResponseEntity.ok(
                ApiResponseFactory.success(
                        ApiActionResponse.builder()
                                .message("Category deleted successfully")
                                .build()
                )
        );
    }



    @CategoryViewApiDocs
    @GetMapping("/{code}")
    @PreAuthorize("hasAuthority('category_read')")
    public ResponseEntity<ApiResponse<CategoryResponse>> view(
            @Parameter(
                    description = "Category unique business code",
                    example = "CAT-001",
                    required = true
            )
            @PathVariable String code) {

        Category category = categoryManagementService.view(
                CategoryCode.of(code)
        );

        CategoryResponse response = categoryMapper.toResponse(category);
        return ResponseEntity.ok(
                ApiResponseFactory.success(response)
        );
    }


    @GetMapping
    @CategoryListApiDocs
    @PreAuthorize("hasAuthority('category_read')")
    public ResponseEntity<ApiPageResponse<CategoryResponse>> list(
            @Valid
            @ParameterObject
            CategoryPageRequest request
    ) {

        PageResult<Category> accounts = categoryManagementService.list(request);

        PageResult<CategoryResponse> response = PageMapper.map(accounts, categoryMapper::toResponse);

        return ResponseEntity.ok(
                ApiResponseFactory.page(response)
        );
    }
}
