package com.amin.e_commerce.category.api.documentation.annotations;

import com.amin.e_commerce.category.api.documentation.examples.CategoryUpdateExamples;
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
        summary = "Update Category",
        description = """
                Updates an existing category.

                Required Authority:
                - category_update

                Business Rules:
                - Category name must be unique.
                - Category name must satisfy validation rules.

                Update Behavior:
                - All fields are optional.
                - Only provided fields are updated.
                - Omitted fields remain unchanged.

                Updatable Fields:
                - name
                - description
                - status
                - image
                """
)

@ApiResponse(
        responseCode = "200",
        description = "Category updated successfully",
        content = @Content(
                schema = @Schema(
                        implementation = CategoryApiResponseSchema.class
                ),
                examples = {
                        @ExampleObject(
                                name = "Category Updated",
                                summary = "Successful category update",
                                value = CategoryUpdateExamples.CATEGORY_UPDATED
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
                                name = "Invalid Name Format",
                                summary = "Category name contains invalid characters",
                                value = CategoryUpdateExamples.INVALID_NAME_FORMAT
                        ),

                        @ExampleObject(
                                name = "Description Too Long",
                                summary = "Category description exceeds maximum length",
                                value = CategoryUpdateExamples.DESCRIPTION_TOO_LONG
                        ),

                        @ExampleObject(
                                name = "Multiple Validation Errors",
                                summary = "Request contains multiple validation violations",
                                value = CategoryUpdateExamples.MULTIPLE_VALIDATION_ERRORS
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
                                value = CategoryUpdateExamples.CATEGORY_NOT_FOUND
                        )
                }
        )
)

@ApiResponse(
        responseCode = "409",
        description = "Business rule violation",
        content = @Content(
                schema = @Schema(
                        implementation = ApiErrorResponse.class
                ),
                examples = {
                        @ExampleObject(
                                name = "Category Name Already Exists",
                                summary = "Category uniqueness violation",
                                value = CategoryUpdateExamples.CATEGORY_NAME_ALREADY_EXISTS
                        )
                }
        )
)

@UnauthorizedApiDocs
@UnauthenticatedApiDocs
@InternalServerErrorApiDocs
public @interface CategoryUpdateApiDocs {
}