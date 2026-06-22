package com.amin.e_commerce.product.api.documentation.schema;

import com.amin.e_commerce.core.api.response.Meta;
import com.amin.e_commerce.core.api.response.PageInfoResponse;
import com.amin.e_commerce.product.api.dto.ProductResponse;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(
        name = "ProductApiPageResponse"
)
public class ProductApiPageResponseSchema {

    @Schema
    public Meta meta;

    @Schema
    public List<ProductResponse> data;

    @Schema
    public PageInfoResponse pageInfo;
}