package com.amin.e_commerce.media.image.domain.generator;


import com.amin.e_commerce.media.core.model.MediaOwnerType;
import com.amin.e_commerce.media.image.application.model.ImageConstants;
import com.amin.e_commerce.media.image.domain.model.ImageResolution;

public class StorageKeyGenerator {

    public static String generate(MediaOwnerType ownerType, String imageCode, ImageResolution resolution) {

        // example: product/IMG-123/original.webp
        // category/IMG-123/large.webp
        // product/IMG-123/square_thumbnail.webp
        return
                ownerType.folder() +
                        "/" +
                        imageCode +
                        "/" +
                        resolution.name().toLowerCase() +
                        "." +
                        ImageConstants.OUTPUT_FORMAT;
    }
}