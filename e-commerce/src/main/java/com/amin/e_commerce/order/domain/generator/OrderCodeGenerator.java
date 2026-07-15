package com.amin.e_commerce.order.domain.generator;

import com.amin.e_commerce.core.generator.UlidGenerator;

public class OrderCodeGenerator {

    public static String generate() {

        return "ORD" + "-" + UlidGenerator.generate();
    }
}
