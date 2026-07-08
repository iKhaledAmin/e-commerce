package com.amin.e_commerce.product.api.dto;

import com.amin.e_commerce.product.domain.value.ProductDescription;
import com.amin.e_commerce.product.domain.value.ProductName;
import com.amin.e_commerce.product.domain.value.ProductPrice;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(
        name = "ProductUpdateRequest",
        description = "Update product request"
)
public class ProductUpdateRequest {

    @Schema(
            example = "Apple iPhone 17 Pro Max",
            description = "Optional name"
    )
    @Pattern(
            regexp = ProductName.PATTERN,
            message = ProductName.PATTERN_ERROR_MESSAGE
    )
    @Size(
            max = ProductName.MAX_LENGTH,
            message = ProductName.MAX_LENGTH_ERROR_MESSAGE
    )
    private String name;

    @Schema(
            example = "Updated product description",
            description = "Optional description"
    )
    @Size(
            max = ProductDescription.MAX_LENGTH,
            message = ProductDescription.MAX_LENGTH_ERROR_MESSAGE
    )
    private String description;

    @Schema(
            example = "1099.99",
            description = "Optional price"
    )
    @DecimalMin(
            value = "0.01",
            message = ProductPrice.NEGATIVE_ERROR_MESSAGE
    )
    private BigDecimal price;

    @Schema(
            example = "CAT-01JY8A7R4W7KX2N8QF5M6P9T3",
            description = "Optional category code"
    )
    private String categoryCode;

    @Schema(
            description = "Optional replacement primary image",
            type = "string",
            format = "binary"
    )
    private MultipartFile primaryImage;

    @ArraySchema(
            schema = @Schema(
                    type = "string",
                    format = "binary"
            ),
            arraySchema = @Schema(
                    description = """
                        Optional replacement gallery images.

                        If provided, all existing gallery images
                        are removed and replaced with the uploaded files.
                        """
            )
    )
    private List<MultipartFile> galleryImages;
}