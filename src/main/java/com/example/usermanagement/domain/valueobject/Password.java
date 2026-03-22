package com.example.usermanagement.domain.valueobject;

public class Password {

    private final String value;

    public Password(String value) {
        if (!isValid(value)) {
            throw new IllegalArgumentException("Weak password");
        }
        this.value = value;
    }

    private boolean isValid(String value) {
        return value.length() >= 8 &&
                value.matches(".*[A-Za-z].*") &&
                value.matches(".*\\d.*");
    }

    public String getValue() {
        return value;
    }
}