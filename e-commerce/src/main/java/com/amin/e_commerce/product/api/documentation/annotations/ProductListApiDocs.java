package com.amin.e_commerce.product.api.documentation.annotations;

import com.amin.e_commerce.core.api.documentation.annotations.InternalServerErrorApiDocs;
import com.amin.e_commerce.core.api.documentation.annotations.UnauthenticatedApiDocs;
import com.amin.e_commerce.core.api.documentation.annotations.UnauthorizedApiDocs;
import com.amin.e_commerce.core.api.response.ApiErrorResponse;
import com.amin.e_commerce.product.api.documentation.examples.ProductListExamples;
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
        summary = "List Products",
        description = """
        Retrieves a paginated list of products.

        Required Authority:
        - product_read

        Intended Consumers:
        - Catalog Managers
        - Product Administrators
        - Internal Back Office Users

        Features:
        - Pagination support
        - Sorting support
        - Category filtering support
        - Product image information

        Visibility Rules:
        - ACTIVE products are returned.
        - DRAFT products are returned.
        - INACTIVE products are returned.

        Category Filtering:
        - categoryCode is optional.
        - When provided, only products belonging to the specified category are returned.
        - When omitted, products from all categories are returned.
        - If the supplied categoryCode does not exist, CATEGORY_NOT_FOUND is returned.

        Pagination Defaults:
        - page = 0
        - size = 20
        - sortBy = NAME
        - direction = DESC

        Typical Use Cases:
        - Product administration
        - Catalog maintenance
        - Internal product management
        """
)

@ApiResponse(
        responseCode = "200",
        description = "Products retrieved successfully",
        content = @Content(
                schema = @Schema(
                        implementation = ProductApiPageResponseSchema.class
                ),
                examples = {
                        @ExampleObject(
                                name = "One Product Retrieved",
                                summary = "Paginated product list with primary images only",
                                value = ProductListExamples.SUCCESS_SHORT_RESPONSE
                        ),
                        @ExampleObject(
                                name = "Multiple Products Retrieved",
                                summary = "Paginated product list with primary image and gallery images",
                                value = ProductListExamples.SUCCESS_FULL_RESPONSE
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
                                value = ProductListExamples.INVALID_PAGE_NUMBER
                        ),
                        @ExampleObject(
                                name = "Invalid Page Size",
                                value = ProductListExamples.INVALID_PAGE_SIZE
                        ),
                        @ExampleObject(
                                name = "Invalid Sort Field",
                                value = ProductListExamples.INVALID_SORT_FIELD
                        ),
                        @ExampleObject(
                                name = "Multiple Validation Errors",
                                value = ProductListExamples.MULTIPLE_VALIDATION_ERRORS
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
                                value = ProductListExamples.CATEGORY_NOT_FOUND
                        )
                }
        )
)

@UnauthenticatedApiDocs
@UnauthorizedApiDocs
@InternalServerErrorApiDocs
public @interface ProductListApiDocs {
}