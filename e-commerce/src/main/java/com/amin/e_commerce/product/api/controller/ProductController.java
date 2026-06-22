package com.amin.e_commerce.product.api.controller;

import com.amin.e_commerce.category.domain.value.CategoryCode;
import com.amin.e_commerce.core.api.pagination.PageMapper;
import com.amin.e_commerce.core.api.pagination.PageResult;
import com.amin.e_commerce.core.api.response.ApiActionResponse;
import com.amin.e_commerce.core.api.response.ApiPageResponse;
import com.amin.e_commerce.core.api.response.ApiResponse;
import com.amin.e_commerce.core.api.response.ApiResponseFactory;
import com.amin.e_commerce.product.api.documentation.annotations.*;
import com.amin.e_commerce.product.api.dto.ProductCreateRequest;
import com.amin.e_commerce.product.api.dto.ProductPageRequest;
import com.amin.e_commerce.product.api.dto.ProductResponse;
import com.amin.e_commerce.product.api.dto.ProductUpdateRequest;
import com.amin.e_commerce.product.api.mapper.ProductMapper;
import com.amin.e_commerce.product.application.service.ProductManagementService;
import com.amin.e_commerce.product.domain.model.Product;
import com.amin.e_commerce.product.domain.value.ProductCode;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "Product Management",
        description = """
                APIs for managing products.

                Features:
                - Create product
                - Update product
                - Delete product
                - View product
                - List products
                - List products by category
                """
)
@RestController
@RequiredArgsConstructor
@RequestMapping("products")
public class ProductController {

    private final ProductManagementService productManagementService;
    private final ProductMapper productMapper;

    @PostMapping
    @ProductCreateApiDocs
    @PreAuthorize("hasAuthority('product_create')")
    public ResponseEntity<ApiResponse<ProductResponse>> create(@Valid @RequestBody ProductCreateRequest request) {

        Product created = productManagementService.create(request);

        ProductResponse response = productMapper.toResponse(created);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponseFactory.success(response));
    }

    @PatchMapping("/{code}")
    @ProductUpdateApiDocs
    @PreAuthorize("hasAuthority('product_update')")
    public ResponseEntity<ApiResponse<ProductResponse>> update(

            @Parameter(
                    description = "Product unique business identifier",
                    example = "PRD-01JY8A7R4W7KX2N8QF5M6P9T3",
                    required = true
            )
            @PathVariable
            String code,

            @Valid
            @RequestBody
            ProductUpdateRequest request
    ) {

        Product updated = productManagementService.update(
                ProductCode.of(code),
                request
        );

        ProductResponse response = productMapper.toResponse(updated);

        return ResponseEntity.ok(
                ApiResponseFactory.success(response)
        );
    }

    @DeleteMapping("/{code}")
    @ProductDeleteApiDocs
    @PreAuthorize("hasAuthority('product_delete')")
    public ResponseEntity<ApiResponse<ApiActionResponse>> delete(

            @Parameter(
                    description = "Product unique business identifier",
                    example = "PRD-01JY8A7R4W7KX2N8QF5M6P9T3",
                    required = true
            )
            @PathVariable
            String code
    ) {

        productManagementService.delete(
                ProductCode.of(code)
        );

        return ResponseEntity.ok(
                ApiResponseFactory.success(
                        ApiActionResponse.builder()
                                .message("Product deleted successfully")
                                .build()
                )
        );
    }

    @ProductViewApiDocs
    @GetMapping("/{code}")
    @PreAuthorize("hasAuthority('product_read')")
    public ResponseEntity<ApiResponse<ProductResponse>> view(

            @Parameter(
                    description = "Product unique business identifier",
                    example = "PRD-01JY8A7R4W7KX2N8QF5M6P9T3",
                    required = true
            )
            @PathVariable
            String code
    ) {

        Product product = productManagementService.view(
                ProductCode.of(code)
        );

        ProductResponse response = productMapper.toResponse(product);

        return ResponseEntity.ok(
                ApiResponseFactory.success(response)
        );
    }


    @ProductViewPurchasableApiDocs
    @GetMapping("/purchasable/{code}")
    @PreAuthorize("hasAuthority('purchasable_product_read')")
    public ResponseEntity<ApiResponse<ProductResponse>> viewPurchasable(
            @Parameter(
                    description = "Product unique business identifier",
                    example = "PRD-01JY8A7R4W7KX2N8QF5M6P9T3",
                    required = true
            )
            @PathVariable
            String code
    ){
        Product product = productManagementService.viewPurchasable(
                ProductCode.of(code)
        );

        ProductResponse response = productMapper.toResponse(product);

        return ResponseEntity.ok(
                ApiResponseFactory.success(response)
        );
    }



    @GetMapping
    @ProductListApiDocs
    @PreAuthorize("hasAuthority('product_read')")
    public ResponseEntity<ApiPageResponse<ProductResponse>> list(

            @Parameter(
                    description = """
                        Optional category business identifier.

                        When provided, only products belonging to the specified
                        category are returned.

                        When omitted, products from all categories are returned.
                        """,
                    example = "CAT-01JY8A7R4W7KX2N8QF5M6P9T3",
                    required = false
            )
            @RequestParam(required = false)
            String categoryCode,

            @Valid
            @ParameterObject
            ProductPageRequest request
    ) {

        PageResult<Product> products =
                productManagementService.list(
                        categoryCode == null ? null : CategoryCode.of(categoryCode),
                        request
                );

        PageResult<ProductResponse> response = PageMapper.map(products, productMapper::toResponse);

        return ResponseEntity.ok(
                ApiResponseFactory.page(response)
        );
    }


    @GetMapping("/purchasable")
    @ProductListPurchasableApiDocs
    @PreAuthorize("hasAuthority('purchasable_product_read')")
    public ResponseEntity<ApiPageResponse<ProductResponse>> listPurchasable(

            @Parameter(
                    description = """
                        Optional category business identifier.

                        When provided, only ACTIVE products belonging to the
                        specified category are returned.

                        When omitted, ACTIVE products from all categories
                        are returned.
                        """,
                    example = "CAT-01JY8A7R4W7KX2N8QF5M6P9T3",
                    required = false
            )
            @RequestParam(required = false)
            String categoryCode,

            @Valid
            @ParameterObject
            ProductPageRequest request
    ) {

        PageResult<Product> products =
                productManagementService.listPurchasable(
                        categoryCode == null ? null : CategoryCode.of(categoryCode),
                        request
                );

        PageResult<ProductResponse> response = PageMapper.map(products, productMapper::toResponse);

        return ResponseEntity.ok(
                ApiResponseFactory.page(response)
        );
    }
}