package com.demater.core.usecase.common.exception;

public class CSVFormatErrorException extends RuntimeException {
    public CSVFormatErrorException(String message) {
        super(message);
    }
}
