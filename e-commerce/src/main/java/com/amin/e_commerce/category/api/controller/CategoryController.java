package com.amin.e_commerce.category.api.controller;

import com.amin.e_commerce.category.api.dto.CategoryCreateRequest;
import com.amin.e_commerce.category.api.dto.CategoryPageRequest;
import com.amin.e_commerce.category.api.dto.CategoryResponse;
import com.amin.e_commerce.category.api.dto.CategoryUpdateRequest;
import com.amin.e_commerce.category.api.mapper.CategoryMapper;
import com.amin.e_commerce.category.application.service.CategoryManagementService;
import com.amin.e_commerce.category.domain.model.Category;
import com.amin.e_commerce.category.domain.value.CategoryCode;
import com.amin.e_commerce.core.api.ActionResponse;
import com.amin.e_commerce.core.api.ApiPageResponse;
import com.amin.e_commerce.core.api.ApiResponse;
import com.amin.e_commerce.core.api.ApiResponseFactory;
import com.amin.e_commerce.core.pagination.PageMapper;
import com.amin.e_commerce.core.pagination.PageResult;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryManagementService categoryManagementService;
    private final CategoryMapper categoryMapper;

    @PreAuthorize("hasAuthority('category_create')")
    @PostMapping
    public ResponseEntity<ApiResponse<CategoryResponse>> create(@Valid @RequestBody CategoryCreateRequest request){

        Category created = categoryManagementService.create(request);
        CategoryResponse response = categoryMapper.toResponse(created);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponseFactory.success(response));
    }

    @PreAuthorize("hasAuthority('category_update')")
    @PatchMapping("/{code}")
    public ResponseEntity<ApiResponse<CategoryResponse>> update(
            @PathVariable String code,
            @Valid @RequestBody CategoryUpdateRequest request) {

        Category updated = categoryManagementService.update(
                CategoryCode.of(code), request
        );

        CategoryResponse response = categoryMapper.toResponse(updated);

        return ResponseEntity.ok(
                ApiResponseFactory.success(response)
        );
    }

    @PreAuthorize("hasAuthority('category_delete')")
    @DeleteMapping("/{code}")
    public ResponseEntity<ApiResponse<ActionResponse>> delete(@PathVariable String code) {

        categoryManagementService.delete(
                CategoryCode.of(code)
        );

        return ResponseEntity.ok(
                ApiResponseFactory.success(
                        ActionResponse.builder()
                                .message("Category deleted successfully")
                                .build()
                )
        );
    }


    @PreAuthorize("hasAuthority('category_read')")
    @GetMapping("/{code}")
    public ResponseEntity<ApiResponse<CategoryResponse>> viewAccount(@PathVariable String code) {

        Category category = categoryManagementService.view(
                CategoryCode.of(code)
        );

        CategoryResponse response = categoryMapper.toResponse(category);
        return ResponseEntity.ok(
                ApiResponseFactory.success(response)
        );
    }


    @GetMapping
    @PreAuthorize("hasAuthority('category_read')")
    public ResponseEntity<ApiPageResponse<CategoryResponse>> listAccounts(@Valid CategoryPageRequest pageRequest) {

        PageResult<Category> accounts = categoryManagementService.list(pageRequest);

        PageResult<CategoryResponse> response = PageMapper.map(accounts, categoryMapper::toResponse);

        return ResponseEntity.ok(
                ApiResponseFactory.page(response)
        );
    }
}
