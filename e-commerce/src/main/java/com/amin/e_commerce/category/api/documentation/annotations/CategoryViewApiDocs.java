package com.amin.e_commerce.category.api.documentation.annotations;

import com.amin.e_commerce.category.api.documentation.examples.CategoryViewExamples;
import com.amin.e_commerce.category.api.documentation.schema.CategoryApiResponseSchema;
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
        summary = "View Category",
        description = """
        Retrieves a single category by its code.

        Required Authority:
        - category_read

        Returns:
        - Category code
        - Category name
        - Category description
        - Category status
        - Category image
        """
)

@ApiResponse(
        responseCode = "200",
        description = "Category retrieved successfully",
        content = @Content(
                schema = @Schema(
                        implementation = CategoryApiResponseSchema.class
                ),
                examples = {
                        @ExampleObject(
                                name = "Category Retrieved",
                                summary = "Successful category retrieval",
                                value = CategoryViewExamples.SUCCESS
                        )
                }
        )
)

@ApiResponse(
        responseCode = "400",
        description = "Invalid category code",
        content = @Content(
                schema = @Schema(
                        implementation = ApiErrorResponse.class
                ),
                examples = {
                        @ExampleObject(
                                name = "Invalid Category Code",
                                summary = "Category code does not match the required format",
                                value = CategoryViewExamples.INVALID_CATEGORY_CODE
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
                                summary = "Requested category does not exist",
                                value = CategoryViewExamples.CATEGORY_NOT_FOUND
                        )
                }
        )
)

@UnauthenticatedApiDocs
@UnauthorizedApiDocs
@InternalServerErrorApiDocs
public @interface CategoryViewApiDocs {
}