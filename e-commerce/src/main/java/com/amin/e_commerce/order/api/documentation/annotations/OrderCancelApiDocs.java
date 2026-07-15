package com.amin.e_commerce.order.api.documentation.annotations;

import com.amin.e_commerce.core.api.documentation.annotations.InternalServerErrorApiDocs;
import com.amin.e_commerce.core.api.documentation.annotations.UnauthenticatedApiDocs;
import com.amin.e_commerce.core.api.documentation.annotations.UnauthorizedApiDocs;
import com.amin.e_commerce.core.api.response.ApiActionResponse;
import com.amin.e_commerce.core.api.response.ApiErrorResponse;
import com.amin.e_commerce.order.api.documentation.examples.OrderCancelExamples;
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
        summary = "Cancel Order",
        description = """
        Cancels an existing order and releases its inventory reservation.

        This endpoint allows customers to cancel orders that are still awaiting confirmation.

        Required Authority:
        - order_cancel

        Business Rules:
        - Order must exist.
        - Order must not already be confirmed.
        - Order must not already be cancelled.
        - Order must not already be expired.
        - Cancelling an order automatically releases the associated inventory reservation.
        - Released inventory becomes available for future reservations.
        - If reservation release fails, order cancellation is not completed.
        """
)

@ApiResponse(
        responseCode = "200",
        description = "Order cancelled successfully",
        content = @Content(
                schema = @Schema(
                        implementation = ApiActionResponse.class
                ),
                examples = {
                        @ExampleObject(
                                name = "Order Cancelled",
                                summary = "Order cancelled and inventory reservation released",
                                value = OrderCancelExamples.ORDER_CANCELLED
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
                                name = "Invalid Order Code",
                                summary = "Order code violates validation rules",
                                value = OrderCancelExamples.INVALID_ORDER_CODE
                        )
                }
        )
)

@ApiResponse(
        responseCode = "404",
        description = "Order not found",
        content = @Content(
                schema = @Schema(
                        implementation = ApiErrorResponse.class
                ),
                examples = {
                        @ExampleObject(
                                name = "Order Not Found",
                                summary = "Requested order does not exist",
                                value = OrderCancelExamples.ORDER_NOT_FOUND
                        )
                }
        )
)

@ApiResponse(
        responseCode = "409",
        description = "Order state conflict",
        content = @Content(
                schema = @Schema(
                        implementation = ApiErrorResponse.class
                ),
                examples = {

                        @ExampleObject(
                                name = "Already Confirmed",
                                summary = "Confirmed orders cannot be cancelled",
                                value = OrderCancelExamples.ALREADY_CONFIRMED
                        ),

                        @ExampleObject(
                                name = "Already Cancelled",
                                summary = "Order was already cancelled",
                                value = OrderCancelExamples.ALREADY_CANCELLED
                        ),

                        @ExampleObject(
                                name = "Already Expired",
                                summary = "Expired orders cannot be cancelled",
                                value = OrderCancelExamples.ALREADY_EXPIRED
                        )
                }
        )
)

@ApiResponse(
        responseCode = "503",
        description = "Order cancellation failed",
        content = @Content(
                schema = @Schema(
                        implementation = ApiErrorResponse.class
                ),
                examples = {
                        @ExampleObject(
                                name = "Cancellation Failed",
                                summary = "Inventory reservation release failed",
                                value = OrderCancelExamples.CANCELLATION_FAILED
                        )
                }
        )
)

@UnauthenticatedApiDocs
@UnauthorizedApiDocs
@InternalServerErrorApiDocs
public @interface OrderCancelApiDocs {
}