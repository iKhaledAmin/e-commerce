package com.amin.e_commerce.category.domain.factory;

import com.amin.e_commerce.category.api.dto.CategoryCreateRequest;
import com.amin.e_commerce.category.domain.command.CategoryCreateCommand;
import com.amin.e_commerce.category.domain.model.Category;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class CategoryFactory {
    private final CategoryCodeGenerator codeGenerator;

    public Category create(@Valid CategoryCreateRequest request) {

        String code = codeGenerator.generate();

        CategoryCreateCommand command = CategoryCreateCommand.of(
                code,
                request.getName(),
                request.getDescription()
        );

        return Category.create(command);

    }
}
