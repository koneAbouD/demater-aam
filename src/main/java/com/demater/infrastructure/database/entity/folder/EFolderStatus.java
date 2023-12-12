package com.demater.infrastructure.database.entity.folder;

public enum EFolderStatus {
    CONFIRMED("CONFIRMED"),
    UNCONFIRMED("UNCONFIRMED");

    private String value;

    EFolderStatus(String value) {
        this.value = value;
    }

    public boolean isLike(String value) {
        return getValue().equalsIgnoreCase(value);
    }

    public String getValue() {
        return value;
    }
}
