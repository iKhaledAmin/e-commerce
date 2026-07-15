package com.amin.e_commerce.order.api.documentation.schema;


import com.amin.e_commerce.core.api.response.Meta;
import com.amin.e_commerce.order.api.dto.OrderDetailsResponse;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
        name = "OrderApiResponse"
)
public class OrderApiResponseSchema {

    @Schema
    public Meta meta;

    @Schema
    public OrderDetailsResponse data;
}