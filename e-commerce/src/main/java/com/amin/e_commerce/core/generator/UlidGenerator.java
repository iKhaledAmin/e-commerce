package com.amin.e_commerce.core.generator;

import com.github.f4b6a3.ulid.UlidCreator;

public class UlidGenerator {
    public static String generate() {
        return UlidCreator.getUlid().toString();
    }
}
