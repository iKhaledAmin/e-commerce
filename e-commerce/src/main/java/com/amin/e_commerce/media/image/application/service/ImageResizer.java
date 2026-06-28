package com.amin.e_commerce.media.image.application.service;

import com.amin.e_commerce.media.image.application.model.GeneratedImageVariant;
import com.amin.e_commerce.media.image.domain.model.ImageResolution;

import java.awt.image.BufferedImage;

public interface ImageResizer {
    GeneratedImageVariant resize(BufferedImage source, ImageResolution resolution);
}