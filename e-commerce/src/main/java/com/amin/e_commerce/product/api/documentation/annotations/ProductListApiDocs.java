package com.amin.e_commerce.product.api.documentation.annotations;

import com.amin.e_commerce.core.api.documentation.annotations.ForbiddenApiDocs;
import com.amin.e_commerce.core.api.documentation.annotations.InternalServerErrorApiDocs;
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

        Features:
        - Pagination support
        - Sorting support

        Supported Sort Fields:
        - NAME
        - CREATED_AT

        Default Values:
        - page = 0
        - size = 20
        - sortBy = NAME
        - direction = DESC
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
                                name = "Products Retrieved",
                                value = ProductListExamples.SUCCESS
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

@ForbiddenApiDocs
@UnauthorizedApiDocs
@InternalServerErrorApiDocs
public @interface ProductListApiDocs {
}