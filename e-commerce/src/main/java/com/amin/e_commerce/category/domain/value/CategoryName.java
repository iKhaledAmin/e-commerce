package com.amin.e_commerce.category.domain.value;

import com.amin.e_commerce.category.exception.CategoryValidationException;

public record CategoryName(String value) {

    public static final int MAX_LENGTH = 50;

    /**
     * Human-readable category name format.
     */
    public static final String PATTERN = "^[A-Za-z]+(?: [A-Za-z]+)*$";

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
                    .withClientDetails("reason", "Category name must not be null or empty");
        }

        if (value.length() > MAX_LENGTH) {
            throw CategoryValidationException.invalidName()
                    .withClientDetails("reason", "Category name exceeds maximum allowed length")
                    .withClientDetails("maxLength", MAX_LENGTH)
                    .withDebugDetails("actualLength", value.length())
                    .withDebugDetails("receivedValue", value);
        }

        if (!value.matches(PATTERN)) {
            throw CategoryValidationException.invalidName()
                    .withClientDetails("reason", "Category name must contain only letters and spaces")
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
