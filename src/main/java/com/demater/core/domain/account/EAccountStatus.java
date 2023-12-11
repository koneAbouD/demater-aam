package com.demater.core.domain.account;

public enum EAccountStatus {
    CONFIRMED("CONFIRMED"),
    UNCONFIRMED("UNCONFIRMED");

    private String value;

    EAccountStatus(String value) {
        this.value = value;
    }

    public boolean isLike(String value) {
        return getValue().equalsIgnoreCase(value);
    }

    public String getValue() {
        return value;
    }
}
