package com.vikas.telecomDiscounts.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum CustomerType {
    REGULAR("Regular"),
    PREMIUM("Premium"),
    GOLD("Gold"),
    DIAMOND("Diamond"),
    PLATINUM("Platinum");

    private final String displayValue;

    CustomerType(String displayValue) {
        this.displayValue = displayValue;
    }

    @JsonValue
    public String getDisplayValue() {
        return displayValue;
    }
}
