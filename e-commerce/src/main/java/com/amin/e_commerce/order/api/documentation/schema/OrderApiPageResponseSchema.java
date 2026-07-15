package com.amin.e_commerce.order.api.documentation.schema;



import com.amin.e_commerce.core.api.response.Meta;
import com.amin.e_commerce.core.api.response.PageInfoResponse;
import com.amin.e_commerce.order.api.dto.OrderSummaryResponse;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(
        name = "OrderApiPageResponse"
)
public class OrderApiPageResponseSchema {

    @Schema
    public Meta meta;

    @Schema
    public List<OrderSummaryResponse> data;

    @Schema
    public PageInfoResponse pageInfo;
}