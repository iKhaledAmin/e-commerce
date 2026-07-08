package com.amin.e_commerce.category.api.documentation.annotations;

import com.amin.e_commerce.category.api.documentation.examples.CategoryListExamples;
import com.amin.e_commerce.category.api.documentation.schema.CategoryApiPageResponseSchema;
import com.amin.e_commerce.core.api.documentation.annotations.InternalServerErrorApiDocs;
import com.amin.e_commerce.core.api.documentation.annotations.UnauthenticatedApiDocs;
import com.amin.e_commerce.core.api.documentation.annotations.UnauthorizedApiDocs;
import com.amin.e_commerce.core.api.response.ApiErrorResponse;
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
        summary = "List Categories",
        description = """
        Retrieves a paginated list of categories.

        Required Authority:
        - category_read

        Features:
        - Pagination support
        - Sorting support

        Business Rules:
        - Page number must be greater than or equal to 0.
        - Page size must be between 1 and 100.
        - Sort field must be one of the supported values.
        - Sort direction must be ASC or DESC.

        Default Values:
        - page = 0
        - size = 20
        - sortBy = NAME
        - direction = DESC
        """
)

@ApiResponse(
        responseCode = "200",
        description = "Categories retrieved successfully",
        content = @Content(
                schema = @Schema(
                        implementation = CategoryApiPageResponseSchema.class
                ),
                examples = {
                        @ExampleObject(
                                name = "Categories Retrieved",
                                summary = "Successful paginated category retrieval",
                                value = CategoryListExamples.SUCCESS
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
                                summary = "Page number must be greater than or equal to zero",
                                value = CategoryListExamples.INVALID_PAGE_NUMBER
                        ),

                        @ExampleObject(
                                name = "Invalid Page Size",
                                summary = "Page size exceeds maximum allowed value",
                                value = CategoryListExamples.INVALID_PAGE_SIZE
                        ),

                        @ExampleObject(
                                name = "Multiple Validation Errors",
                                summary = "Request contains more than one validation violation",
                                value = CategoryListExamples.MULTIPLE_VALIDATION_ERRORS
                        ),

                        @ExampleObject(
                                name = "Invalid Sort Field",
                                summary = "Unsupported category sorting field",
                                value = CategoryListExamples.INVALID_SORT_FIELD
                        )
                }
        )
)

@UnauthenticatedApiDocs
@UnauthorizedApiDocs
@InternalServerErrorApiDocs
public @interface CategoryListApiDocs {
}