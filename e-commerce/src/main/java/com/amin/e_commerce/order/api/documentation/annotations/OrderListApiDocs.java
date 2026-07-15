package com.amin.e_commerce.order.api.documentation.annotations;

import com.amin.e_commerce.core.api.documentation.annotations.InternalServerErrorApiDocs;
import com.amin.e_commerce.core.api.documentation.annotations.UnauthenticatedApiDocs;
import com.amin.e_commerce.core.api.documentation.annotations.UnauthorizedApiDocs;
import com.amin.e_commerce.core.api.response.ApiErrorResponse;
import com.amin.e_commerce.order.api.documentation.examples.OrderListExamples;
import com.amin.e_commerce.order.api.documentation.schema.OrderApiPageResponseSchema;
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
        summary = "List Orders",
        description = """
        Returns a paginated list of customer orders.

        Required Authority:
        - order_read

        Features:
        - Pagination support
        - Sorting support

        Business Rules:
        - Only orders belonging to the authenticated customer are returned.
        - Page number must be greater than or equal to 0.
        - Page size must be between 1 and 100.
        - Sort field must be one of the supported values.
        - Sort direction must be ASC or DESC.

        Default Values:
        - page = 0
        - size = 20
        - sortBy = CREATED_AT
        - direction = DESC

        Response Characteristics:
        - Lightweight response optimized for order history screens.
        - Does not include order item details.
        - Includes order status and payment status summary.
        - Supports pagination and sorting.
        """
)

@ApiResponse(
        responseCode = "200",
        description = "Orders retrieved successfully",
        content = @Content(
                schema = @Schema(
                        implementation = OrderApiPageResponseSchema.class
                ),
                examples = {
                        @ExampleObject(
                                name = "Paginated Order List",
                                summary = "Successful order listing",
                                value = OrderListExamples.SUCCESS_RESPONSE
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
                                summary = "Page number violates validation rules",
                                value = OrderListExamples.INVALID_PAGE_NUMBER
                        ),

                        @ExampleObject(
                                name = "Invalid Page Size",
                                summary = "Page size violates validation rules",
                                value = OrderListExamples.INVALID_PAGE_SIZE
                        ),

                        @ExampleObject(
                                name = "Invalid Sort Field",
                                summary = "Sort field is not supported",
                                value = OrderListExamples.INVALID_SORT_FIELD
                        ),

                        @ExampleObject(
                                name = "Multiple Validation Errors",
                                summary = "Request contains multiple validation violations",
                                value = OrderListExamples.MULTIPLE_VALIDATION_ERRORS
                        )
                }
        )
)

@UnauthenticatedApiDocs
@UnauthorizedApiDocs
@InternalServerErrorApiDocs
public @interface OrderListApiDocs {
}