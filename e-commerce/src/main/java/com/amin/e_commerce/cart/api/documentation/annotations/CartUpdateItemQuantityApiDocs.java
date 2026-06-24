package com.amin.e_commerce.cart.api.documentation.annotations;

import com.amin.e_commerce.cart.api.documentation.examples.CartUpdateItemQuantityExamples;
import com.amin.e_commerce.cart.api.documentation.schema.CartApiResponseSchema;
import com.amin.e_commerce.core.api.documentation.annotations.ForbiddenApiDocs;
import com.amin.e_commerce.core.api.documentation.annotations.InternalServerErrorApiDocs;
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
        summary = "Update Cart Item Quantity",
        description = """
        Updates quantity of an existing cart item.

        Required Authority:
        - cart_update_item

        Business Rules:
        - Cart item must exist.
        - Cart must be modifiable.
        """
)

@ApiResponse(
        responseCode = "200",
        description = "Cart item updated successfully",
        content = @Content(
                schema = @Schema(
                        implementation = CartApiResponseSchema.class
                ),
                examples = {
                        @ExampleObject(
                                name = "Item Updated",
                                value = CartUpdateItemQuantityExamples.SUCCESS
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
                                name = "Invalid Quantity",
                                value = CartUpdateItemQuantityExamples.INVALID_QUANTITY
                        ),
                        @ExampleObject(
                                name = "Multiple Validation Errors",
                                value = CartUpdateItemQuantityExamples.MULTIPLE_VALIDATION_ERRORS
                        )
                }
        )
)

@ApiResponse(
        responseCode = "404",
        description = "Cart item not found",
        content = @Content(
                schema = @Schema(
                        implementation = ApiErrorResponse.class
                ),
                examples = {
                        @ExampleObject(
                                name = "Cart Item Not Found",
                                value = CartUpdateItemQuantityExamples.ITEM_NOT_FOUND
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
                                value = CartUpdateItemQuantityExamples.CART_MODIFICATION_NOT_ALLOWED
                        )
                }
        )
)

@ForbiddenApiDocs
@UnauthorizedApiDocs
@InternalServerErrorApiDocs
public @interface CartUpdateItemQuantityApiDocs {
}