package com.amin.e_commerce.core.logging.core;

import com.github.f4b6a3.ulid.UlidCreator;
import org.springframework.stereotype.Component;

@Component
public class UlidRequestIdGenerator implements RequestIdGenerator {

    @Override
    public String generate() {
        return UlidCreator.getUlid().toString();
    }
}
