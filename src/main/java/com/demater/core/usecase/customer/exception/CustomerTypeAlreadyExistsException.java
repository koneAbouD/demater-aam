package com.demater.core.usecase.customer.exception;

public class CustomerTypeAlreadyExistsException extends RuntimeException {
    public CustomerTypeAlreadyExistsException(String message) {
        super(message);
    }
}
