package com.amin.e_commerce.core.logging.core;

import com.amin.e_commerce.core.generator.UniqueIdentifierGenerator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class RequestIdGenerator {

    private final UniqueIdentifierGenerator generator;

    String generate() {
       return generator.generate();
    }
}

