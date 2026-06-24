package com.amin.e_commerce.cart.api.documentation.schema;

import com.amin.e_commerce.cart.api.dto.CartResponse;
import com.amin.e_commerce.core.api.response.Meta;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
        name = "CartApiResponse"
)
public class CartApiResponseSchema {

    @Schema
    public Meta meta;

    @Schema
    public CartResponse data;
}