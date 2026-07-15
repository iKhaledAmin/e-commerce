package com.amin.e_commerce.order.domain.model;

import com.amin.e_commerce.order.exception.OrderValidationException;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderSortField {
    CREATED_AT("createdAt"),
    TOTAL_AMOUNT("totalAmount");

    private final String field;


    public static String getDefault() {
        return CREATED_AT.getField();
    }

    public static String getFieldFrom(String queryParam) {
        try {
            return OrderSortField.valueOf(queryParam).getField();
        } catch (IllegalArgumentException e) {
            throw OrderValidationException.invalidSortField()
                    .withDebugDetails("sortField" , queryParam);
        }
    }
}
