package com.amin.e_commerce.product.domain.factory;

import com.amin.e_commerce.category.domain.model.Category;
import com.amin.e_commerce.product.api.dto.ProductCreateRequest;
import com.amin.e_commerce.product.domain.command.ProductCreateCommand;
import com.amin.e_commerce.product.domain.model.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class ProductFactory {
    private final ProductCodeGenerator codeGenerator;

    public Product create(ProductCreateRequest request, Category category){
        String code = codeGenerator.generate();

        ProductCreateCommand command = ProductCreateCommand.of(
                code,
                request.getName(),
                request.getDescription(),
                request.getPrice(),
                category
        );

        return Product.create(command);
    }
}
