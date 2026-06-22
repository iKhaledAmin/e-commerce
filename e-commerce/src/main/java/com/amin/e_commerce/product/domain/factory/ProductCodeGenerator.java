package com.amin.e_commerce.product.domain.factory;

import com.amin.e_commerce.core.generator.UniqueIdentifierGenerator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class ProductCodeGenerator {
    private final UniqueIdentifierGenerator generator;

    String generate() {

        return  "PRO" + "-" + generator.generate();
    }
}
