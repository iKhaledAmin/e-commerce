package com.amin.e_commerce.cart.api.documentation.annotations;

import com.amin.e_commerce.cart.api.documentation.examples.CartClearItemsExamples;
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
        summary = "Clear Cart",
        description = """
        Removes all items from the authenticated customer's cart.

        Required Authority:
        - cart_clear_items

        Business Rules:
        - Cart must be modifiable.
        """
)

@ApiResponse(
        responseCode = "200",
        description = "Cart cleared successfully",
        content = @Content(
                schema = @Schema(
                        implementation = CartApiResponseSchema.class
                ),
                examples = {
                        @ExampleObject(
                                name = "Cart Cleared",
                                value = CartClearItemsExamples.SUCCESS
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
                                value = CartClearItemsExamples.CART_MODIFICATION_NOT_ALLOWED
                        )
                }
        )
)

@UnauthenticatedApiDocs
@UnauthorizedApiDocs
@InternalServerErrorApiDocs
public @interface CartClearCartApiDocs {
}