package com.amin.e_commerce.media.image.application.model;

import java.io.InputStream;

public record GeneratedImageVariant(
        InputStream content,
        int width,
        int height,
        long fileSize,
        String mimeType
) {
}