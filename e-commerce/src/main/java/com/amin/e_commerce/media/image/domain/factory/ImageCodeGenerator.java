package com.amin.e_commerce.media.image.domain.factory;

import com.amin.e_commerce.core.generator.UniqueIdentifierGenerator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class ImageCodeGenerator {
    private final UniqueIdentifierGenerator generator;

    String generate() {

        return  "IMG" + "-" + generator.generate();
    }
}
