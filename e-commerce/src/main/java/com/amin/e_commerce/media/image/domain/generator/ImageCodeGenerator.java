package com.amin.e_commerce.media.image.domain.generator;


import com.amin.e_commerce.core.generator.UlidGenerator;

public class ImageCodeGenerator {

    public static String generate() {

        return  "IMG" + "-" + UlidGenerator.generate();
    }
}
