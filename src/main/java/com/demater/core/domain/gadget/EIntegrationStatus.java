package com.demater.core.domain.gadget;

public enum EIntegrationStatus {
    CONFIRMED("CONFIRMED"),
    UNCONFIRMED("UNCONFIRMED");

    private String value;

    EIntegrationStatus(String value) {
        this.value = value;
    }

    public boolean isLike(String value) {
        return getValue().equalsIgnoreCase(value);
    }

    public String getValue() {
        return value;
    }
}
