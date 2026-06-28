package com.amin.e_commerce.product.api.dto;

import com.amin.e_commerce.product.domain.value.ProductDescription;
import com.amin.e_commerce.product.domain.value.ProductName;
import com.amin.e_commerce.product.domain.value.ProductPrice;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
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
        name = "ProductCreateRequest",
        description = "Create product request"
)
public class ProductCreateRequest {

    @Schema(
            example = "Apple iPhone 17 Pro",
            description = "Mandatory name",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotEmpty(message = ProductName.NULL_ERROR_MESSAGE)
    @NotBlank(message = ProductName.NULL_ERROR_MESSAGE)
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
            example = "Latest Apple flagship smartphone",
            description = "Optional description",
            nullable = true
    )
    @Size(
            max = ProductDescription.MAX_LENGTH,
            message = ProductDescription.MAX_LENGTH_ERROR_MESSAGE
    )
    private String description;

    @Schema(
            example = "999.99",
            description = "Mandatory price",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotNull(message = ProductPrice.NULL_ERROR_MESSAGE)
    @DecimalMin(
            value = "0.01",
            message = ProductPrice.NEGATIVE_ERROR_MESSAGE
    )
    private BigDecimal price;

    @Schema(
            example = "CAT-01JY8A7R4W7KX2N8QF5M6P9T3",
            description = "Mandatory category code",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotBlank(message = "Category code is mandatory")
    private String categoryCode;

    @Schema(
            description = "Mandatory primary image",
            requiredMode = Schema.RequiredMode.REQUIRED,
            type = "string",
            format = "binary"
    )
    @NotNull(message = "Primary image is mandatory")
    private MultipartFile primaryImage;


    @ArraySchema(
            schema = @Schema(
                    type = "string",
                    format = "binary"
            ),
            arraySchema = @Schema(
                    description = """
                        Optional gallery images.
                        These images are displayed in the product gallery.
                        """
            )
    )
    private List<MultipartFile> galleryImages;
}