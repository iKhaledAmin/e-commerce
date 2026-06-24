package com.amin.e_commerce.cart.domain.command;

import com.amin.e_commerce.cart.domain.value.CartItemUnitPrice;
import com.amin.e_commerce.product.domain.value.ProductCode;

import java.math.BigDecimal;

public record CartUpdateItemUnitPriceCommand(ProductCode productCode, CartItemUnitPrice unitPrice)  {
    public static CartUpdateItemUnitPriceCommand of(String productCode, BigDecimal unitPrice) {
        return new CartUpdateItemUnitPriceCommand(
                ProductCode.of(productCode),
                CartItemUnitPrice.of(unitPrice)
        );
    }

}
