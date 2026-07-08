package com.amin.e_commerce.product.domain.generator;

import com.amin.e_commerce.core.generator.UlidGenerator;

public class ProductCodeGenerator {

    public static String generate() {

        return  "PRO" + "-" + UlidGenerator.generate();
    }
}
