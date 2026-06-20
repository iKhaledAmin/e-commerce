package com.amin.e_commerce.category.api.documentation.annotations;

import com.amin.e_commerce.category.api.documentation.examples.CategoryDeleteExamples;
import com.amin.e_commerce.category.api.documentation.schema.CategoryApiActionResponseSchema;
import com.amin.e_commerce.core.api.documentation.annotations.ForbiddenApiDocs;
import com.amin.e_commerce.core.api.documentation.annotations.InternalServerErrorApiDocs;
import com.amin.e_commerce.core.api.documentation.annotations.UnauthorizedApiDocs;
import com.amin.e_commerce.core.api.response.ApiErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)

@Operation(
        summary = "Delete Category",
        description = """
        Soft deletes a category.

        Required Authority:
        - category_delete

        Business Behavior:
        - Category is not physically removed
        - Category status becomes INACTIVE
        - Historical references remain intact
        - Audit information is preserved
        """
)

@ApiResponse(
        responseCode = "200",
        description = "Category deleted successfully",
        content = @Content(
                schema = @Schema(
                        implementation = CategoryApiActionResponseSchema.class
                ),
                examples = {
                        @ExampleObject(
                                name = "Category Deleted",
                                summary = "Successful soft delete operation",
                                value = CategoryDeleteExamples.CATEGORY_DELETED
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
                                summary = "Category does not exist with provided code",
                                value = CategoryDeleteExamples.CATEGORY_NOT_FOUND
                        )
                }
        )
)
@ForbiddenApiDocs
@UnauthorizedApiDocs
@InternalServerErrorApiDocs
public @interface CategoryDeleteApiDocs {
}