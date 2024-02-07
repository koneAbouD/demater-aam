package com.demater.core.usecase.customer.exception;

public class CustomerTypeNotFoundException extends RuntimeException {
    public CustomerTypeNotFoundException(String message) {
        super(message);
    }
}
