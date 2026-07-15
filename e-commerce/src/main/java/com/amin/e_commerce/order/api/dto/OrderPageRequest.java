package com.amin.e_commerce.order.api.dto;


import com.amin.e_commerce.core.api.pagination.PageRequest;
import com.amin.e_commerce.order.domain.model.OrderSortField;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Schema(
        name = "OrderPageRequest",
        description = "order page request"
)
public class OrderPageRequest extends PageRequest {
    @Schema(
            description = "Order sorting field",
            allowableValues = {
                    "CREATED_AT",
                    "TOTAL_AMOUNT"
            },
            example = "CREATED_AT"
    )
    private String sortBy = OrderSortField.getDefault();



    @Override
    public String getSortBy() {
        return OrderSortField.getFieldFrom(sortBy);
    }
}
