package com.amin.e_commerce.category.domain.value;

import com.amin.e_commerce.category.exception.CategoryValidationException;

import java.util.Locale;

public record CategoryCode(String value) {

    public CategoryCode {
        value = normalize(value);
        validate(value);
    }


    private static String normalize(String value) {
        return value == null ? null : value.trim().toUpperCase(Locale.ROOT);
    }

    private static void validate(String value) {
        if (value == null || value.isBlank()) {
            throw CategoryValidationException.invalidCode()
                    .withDebugDetails("categoryCode", value);
        }
    }

    public static CategoryCode of(String value) {
        return new CategoryCode(value);
    }

    @Override
    public String toString() {
        return value;
    }



}
