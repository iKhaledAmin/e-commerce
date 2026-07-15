package com.amin.e_commerce.order.api.documentation.schema;

import com.amin.e_commerce.core.api.response.Meta;
import com.amin.e_commerce.order.api.dto.OrderPlacementResponse;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
        name = "OrderPlacementApiResponse"
)
public class OrderPlacementApiResponseSchema {

    @Schema
    public Meta meta;

    @Schema
    public OrderPlacementResponse data;
}
