package com.demater.core.usecase.customer.exception;

public class CustomerConfirmationNotFoundException extends RuntimeException {
    public CustomerConfirmationNotFoundException(String message) {
        super(message);
    }
}
