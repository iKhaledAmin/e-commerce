package com.amin.e_commerce.product.api.documentation.annotations;

import com.amin.e_commerce.core.api.documentation.annotations.InternalServerErrorApiDocs;
import com.amin.e_commerce.core.api.documentation.annotations.UnauthenticatedApiDocs;
import com.amin.e_commerce.core.api.documentation.annotations.UnauthorizedApiDocs;
import com.amin.e_commerce.core.api.response.ApiActionResponse;
import com.amin.e_commerce.core.api.response.ApiErrorResponse;
import com.amin.e_commerce.product.api.documentation.examples.ProductConnectStockExamples;
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
        summary = "Connect Product To Stock",
        description = """
        Connects a product to an inventory stock item.

        Required Authority:
        - product_connect_stock

        Intended Consumers:
        - Catalog Managers
        - Product Administrators
        - Inventory Administrators

        Business Rules:
        - Product must exist.
        - Product can only be connected once.
        - Target stock must already exist in Inventory System (stock exists but may not have quantity yet).
        - Product status is not changed automatically.
        - Product activation remains a separate operation.

        Typical Use Cases:
        - Product onboarding workflow
        - Catalog preparation before publication
        - Inventory synchronization
        - Product-stock association

        Notes:
        - This operation establishes the relationship between
          Product and Inventory Stock.
        - Inventory ownership remains inside Inventory System.
        - Only the stock business identifier is stored
          inside Product domain.
        """
)

@ApiResponse(
        responseCode = "200",
        description = "Product connected to stock successfully",
        content = @Content(
                schema = @Schema(
                        implementation = ApiActionResponse.class
                ),
                examples = {
                        @ExampleObject(
                                name = "Stock Connected",
                                value = ProductConnectStockExamples.SUCCESS_RESPONSE
                        )
                }
        )
)

@ApiResponse(
        responseCode = "400",
        description = "Invalid request payload",
        content = @Content(
                schema = @Schema(
                        implementation = ApiErrorResponse.class
                ),
                examples = {
                        @ExampleObject(
                                name = "Validation Failed",
                                value = ProductConnectStockExamples.INVALID_STOCK_CODE
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
                                value = ProductConnectStockExamples.PRODUCT_NOT_FOUND
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
                                name = "Stock Already Connected",
                                value = ProductConnectStockExamples.STOCK_ALREADY_CONNECTED
                        ),
                        @ExampleObject(
                                name = "Stock Not Initialized",
                                value = ProductConnectStockExamples.STOCK_NOT_INITIALIZED
                        )
                }
        )
)

@UnauthenticatedApiDocs
@UnauthorizedApiDocs
@InternalServerErrorApiDocs
public @interface ProductConnectStockApiDocs {
}