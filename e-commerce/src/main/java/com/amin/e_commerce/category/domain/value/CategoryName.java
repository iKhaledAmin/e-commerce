package com.amin.e_commerce.category.domain.value;

import com.amin.e_commerce.category.exception.CategoryValidationException;

public record CategoryName(String value) {


    public static final String NULL_ERROR_MESSAGE = "Category name must not be null or empty";

    public static final int MAX_LENGTH = 50;
    public static final String MAX_LENGTH_ERROR_MESSAGE = "Category name exceeds maximum allowed length";

    public static final String PATTERN = "^[A-Za-z]+(?: [A-Za-z]+)*$";
    public static final String PATTERN_ERROR_MESSAGE = "Category name must contain only letters and spaces";


    public CategoryName {
        value = normalize(value);
        validate(value);
    }

    private static String normalize(String value) {
        return value == null ? null : value.trim().replaceAll("\\s+", " ");
    }

    private static void validate(String value) {

        if (value == null || value.isBlank()) {
            throw CategoryValidationException.invalidName()
                    .withClientDetails("reason",NULL_ERROR_MESSAGE);
        }

        if (value.length() > MAX_LENGTH) {
            throw CategoryValidationException.invalidName()
                    .withClientDetails("reason", MAX_LENGTH_ERROR_MESSAGE)
                    .withClientDetails("maxLength", MAX_LENGTH)
                    .withDebugDetails("actualLength", value.length())
                    .withDebugDetails("receivedValue", value);
        }

        if (!value.matches(PATTERN)) {
            throw CategoryValidationException.invalidName()
                    .withClientDetails("reason",PATTERN_ERROR_MESSAGE)
                    .withClientDetails("expectedFormat", "letters_and_spaces_only")
                    .withDebugDetails("receivedValue", value)
                    .withDebugDetails("pattern", PATTERN);
        }
    }

    public static CategoryName of(String value) {
        return new CategoryName(value);
    }

    @Override
    public String toString() {
        return value;
    }

}
