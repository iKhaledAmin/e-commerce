package com.amin.e_commerce.media.image.domain.factory;

import com.amin.e_commerce.media.image.domain.model.Image;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@Component
public class ImageFactory {

    private final ImageCodeGenerator imageCodeGenerator;

    public Image create(MultipartFile file) {

        return Image.create(
                imageCodeGenerator.generate(),
                file
        );
    }
}
