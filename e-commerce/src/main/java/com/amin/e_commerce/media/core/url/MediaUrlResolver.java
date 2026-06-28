package com.amin.e_commerce.media.core.url;

import com.amin.e_commerce.media.core.model.MediaType;

public interface MediaUrlResolver {
    // Responsible for generating public access URLs
    // storageKey: unique identifier for the media file
    String resolve(MediaType mediaType, String storageKey);
}
