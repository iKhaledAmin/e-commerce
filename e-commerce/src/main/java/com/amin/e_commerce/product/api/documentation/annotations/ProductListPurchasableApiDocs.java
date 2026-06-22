package com.amin.e_commerce.product.api.documentation.annotations;

import com.amin.e_commerce.core.api.documentation.annotations.ForbiddenApiDocs;
import com.amin.e_commerce.core.api.documentation.annotations.InternalServerErrorApiDocs;
import com.amin.e_commerce.core.api.documentation.annotations.UnauthorizedApiDocs;
import com.amin.e_commerce.core.api.response.ApiErrorResponse;
import com.amin.e_commerce.product.api.documentation.examples.ProductListPurchasableExamples;
import com.amin.e_commerce.product.api.documentation.schema.ProductApiPageResponseSchema;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented

@Operation(
        summary = "List Purchasable Products",
        description = """
        Retrieves a paginated list of products available for purchase.

        Required Authority:
        - purchasable_product_read

        Intended Consumers:
        - Storefront Applications
        - Mobile Applications
        - Product Catalog Pages
        - Customer Shopping Experiences

        Features:
        - Pagination support
        - Sorting support
        - Category filtering support

        Visibility Rules:
        - Only ACTIVE products are returned.
        - DRAFT products are excluded.
        - INACTIVE products are excluded.

        Category Filtering:
        - categoryCode is optional.
        - When provided, only ACTIVE products belonging to the specified category are returned.
        - When omitted, all ACTIVE products are returned.
        - If the supplied categoryCode does not exist, CATEGORY_NOT_FOUND is returned.

        Business Purpose:
        - Product catalogs
        - Category browsing
        - Search results
        - Customer shopping experiences

        Pagination Defaults:
        - page = 0
        - size = 20
        - sortBy = NAME
        - direction = DESC
        """
)

@ApiResponse(
        responseCode = "200",
        description = "Purchasable products retrieved successfully",
        content = @Content(
                schema = @Schema(
                        implementation = ProductApiPageResponseSchema.class
                ),
                examples = {
                        @ExampleObject(
                                name = "Purchasable Products Retrieved",
                                value = ProductListPurchasableExamples.SUCCESS
                        )
                }
        )
)

@ApiResponse(
        responseCode = "400",
        description = "Validation failed",
        content = @Content(
                schema = @Schema(
                        implementation = ApiErrorResponse.class
                ),
                examples = {
                        @ExampleObject(
                                name = "Invalid Page Number",
                                value = ProductListPurchasableExamples.INVALID_PAGE_NUMBER
                        ),
                        @ExampleObject(
                                name = "Invalid Page Size",
                                value = ProductListPurchasableExamples.INVALID_PAGE_SIZE
                        ),
                        @ExampleObject(
                                name = "Invalid Sort Field",
                                value = ProductListPurchasableExamples.INVALID_SORT_FIELD
                        ),
                        @ExampleObject(
                                name = "Multiple Validation Errors",
                                value = ProductListPurchasableExamples.MULTIPLE_VALIDATION_ERRORS
                        )
                }
        )
)
@ApiResponse(
        responseCode = "404",
        description = "Category not found",
        content = @Content(
                schema = @Schema(
                        implementation = ApiErrorResponse.class
                ),
                examples = {
                        @ExampleObject(
                                name = "Category Not Found",
                                value = ProductListPurchasableExamples.CATEGORY_NOT_FOUND
                        )
                }
        )
)

@ForbiddenApiDocs
@UnauthorizedApiDocs
@InternalServerErrorApiDocs
public @interface ProductListPurchasableApiDocs {
}