package com.demater.infrastructure.database.entity.reference;

public enum EAddressType {
    COURRIER("C"),
    DECLARATIVE("D"),
    PROVISOIRE("P");
    private String value;

    EAddressType(String value) {
        this.value = value;
    }

    public boolean isLike(String value) {
        return getValue().equalsIgnoreCase(value);
    }

    public String getValue() {
        return value;
    }
}
