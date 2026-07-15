package com.amin.e_commerce.order.domain.command;

import com.amin.e_commerce.order.domain.value.OrderMoney;
import com.amin.e_commerce.order.domain.value.OrderQuantity;
import com.amin.e_commerce.product.domain.value.ProductCode;
import com.amin.e_commerce.product.domain.value.ProductName;

import java.math.BigDecimal;

public record OrderItemCreateCommand(

        ProductCode productCode,
        ProductName productName,
        String productThumbnailStorageKey,
        OrderMoney unitPrice,
        OrderQuantity quantity

) {
    public static OrderItemCreateCommand of(
            String productCode,
            String productName,
            String productThumbnailStorageKey,
            BigDecimal unitPrice,
            Integer quantity
    ){
        return new OrderItemCreateCommand(
                ProductCode.of(productCode),
                ProductName.of(productName),
                productThumbnailStorageKey,
                OrderMoney.of(unitPrice),
                OrderQuantity.of(quantity)
        );
    }
}