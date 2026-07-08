package com.amin.e_commerce.category.domain.generator;

import com.amin.e_commerce.core.generator.UlidGenerator;

public class CategoryCodeGenerator {

    public static String generate() {

        return  "CAT" + "-" + UlidGenerator.generate();
    }
}