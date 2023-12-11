package com.demater.core.domain.common;

public class StringUtils {
    public static boolean isValueContains(String value, String searchValue) {
        if (searchValue == null) {
            return true;
        }
        return value.toLowerCase().contains(searchValue.toLowerCase());
    }
}
