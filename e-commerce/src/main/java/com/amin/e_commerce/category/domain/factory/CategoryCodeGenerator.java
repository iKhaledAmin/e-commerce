package com.amin.e_commerce.category.domain.factory;

import com.amin.e_commerce.core.generator.UniqueIdentifierGenerator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
class CategoryCodeGenerator {

    private final UniqueIdentifierGenerator generator;

    String generate() {

        return  "CAT" + "-" + generator.generate();
    }
}