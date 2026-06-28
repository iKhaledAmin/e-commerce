package com.amin.e_commerce.category.domain.model;

import com.amin.e_commerce.media.image.domain.model.ImageResolution;
import com.amin.e_commerce.media.image.domain.model.ImagePreset;


import java.util.Set;


public final class CategoryImagePreset implements ImagePreset {

    public static final CategoryImagePreset INSTANCE = new CategoryImagePreset();

    @Override
    public Set<ImageResolution> resolutions(){
        return Set.of(
                ImageResolution.LARGE,
                ImageResolution.SQUARE_MEDIUM
        );
    }
}
