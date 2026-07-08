package com.amin.e_commerce.cart.api.documentation.annotations;

import com.amin.e_commerce.cart.api.documentation.examples.CartAddItemExamples;
import com.amin.e_commerce.cart.api.documentation.schema.CartApiResponseSchema;
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
        summary = "Add Item To Cart",
        description = """
        Adds a product to the authenticated customer's cart.

        Required Authority:
        - cart_add_item

        Business Rules:
        - Product must exist.
        - Cart must be modifiable (in active state).
        - New cart is automatically created if none exists.
        """
)

@ApiResponse(
        responseCode = "200",
        description = "Item added successfully",
        content = @Content(
                schema = @Schema(
                        implementation = CartApiResponseSchema.class
                ),
                examples = {
                        @ExampleObject(
                                name = "Item Added",
                                summary = "Successful item addition",
                                value = CartAddItemExamples.SUCCESS
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
                                name = "Missing Product Code",
                                value = CartAddItemExamples.MISSING_PRODUCT_CODE
                        ),
                        @ExampleObject(
                                name = "Invalid Quantity",
                                value = CartAddItemExamples.INVALID_QUANTITY
                        ),
                        @ExampleObject(
                                name = "Multiple Validation Errors",
                                value = CartAddItemExamples.MULTIPLE_VALIDATION_ERRORS
                        )
                }
        )
)

@ApiResponse(
        responseCode = "404",
        description = "Product not found",
        content = @Content(
                schema = @Schema(
                        implementation = ApiErrorResponse.class
                ),
                examples = {
                        @ExampleObject(
                                name = "Product Not Found",
                                value = CartAddItemExamples.PRODUCT_NOT_FOUND
                        )
                }
        )
)

@ApiResponse(
        responseCode = "409",
        description = "Cart modification not allowed",
        content = @Content(
                schema = @Schema(
                        implementation = ApiErrorResponse.class
                ),
                examples = {
                        @ExampleObject(
                                name = "Cart Modification Not Allowed",
                                value = CartAddItemExamples.CART_MODIFICATION_NOT_ALLOWED

                        )
                }
        )
)

@UnauthenticatedApiDocs
@UnauthorizedApiDocs
@InternalServerErrorApiDocs
public @interface CartAddItemApiDocs {
}