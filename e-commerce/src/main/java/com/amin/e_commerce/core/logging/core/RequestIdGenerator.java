package com.amin.e_commerce.core.logging.core;

import com.amin.e_commerce.core.generator.UlidGenerator;

public class RequestIdGenerator {

    public static String generate() {
       return UlidGenerator.generate();
    }
}

