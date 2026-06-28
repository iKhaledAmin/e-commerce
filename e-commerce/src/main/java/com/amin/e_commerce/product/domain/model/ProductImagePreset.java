package com.amin.e_commerce.product.domain.model;

import com.amin.e_commerce.media.image.domain.model.ImageResolution;
import com.amin.e_commerce.media.image.domain.model.ImagePreset;

import java.util.Set;

public final class ProductImagePreset implements ImagePreset {

    public static final ProductImagePreset INSTANCE = new ProductImagePreset();

    @Override
    public Set<ImageResolution> resolutions(){
        return Set.of(
                ImageResolution.LARGE,
                ImageResolution.MEDIUM,
                ImageResolution.SQUARE_THUMBNAIL,
                ImageResolution.SQUARE_MEDIUM
        );
    }
}