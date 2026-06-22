package com.amin.e_commerce.product.api.documentation.schema;

import com.amin.e_commerce.core.api.response.Meta;
import com.amin.e_commerce.product.api.dto.ProductResponse;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
        name = "ProductApiResponse"
)
public class ProductApiResponseSchema {

    @Schema
    public Meta meta;

    @Schema
    public ProductResponse data;
}