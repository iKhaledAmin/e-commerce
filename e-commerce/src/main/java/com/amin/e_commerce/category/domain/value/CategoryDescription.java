package com.amin.e_commerce.category.domain.value;


import com.amin.e_commerce.category.exception.CategoryValidationException;

public record CategoryDescription(String value) {

    public static final String MAX_LENGTH_ERROR_MESSAGE = "Category description is too long";
    public static final int MAX_LENGTH = 255;

    public CategoryDescription {
        value = normalize(value);
        validate(value);
    }

    private static String normalize(String value) {

        if (value == null) {
            return null;
        }

        value = value.trim();

        return value.isBlank() ? null : value;
    }

    private static void validate(String value) {

        // optional field
        if (value == null) {
            return;
        }

        if (value.length() > MAX_LENGTH) {
            throw CategoryValidationException.invalidDescription()
                    .withClientDetails("reason", MAX_LENGTH_ERROR_MESSAGE)
                    .withClientDetails("maxLength", MAX_LENGTH)
                    .withDebugDetails("actualLength", value.length())
                    .withDebugDetails("receivedValue", value);
        }
    }

    public static CategoryDescription of(String value) {
        return new CategoryDescription(value);
    }

    @Override
    public String toString() {
        return value;
    }
}
