package com.demater.core.usecase.account.exception;

public class AccountConfirmationNotFoundException extends RuntimeException {
    public AccountConfirmationNotFoundException(String message) {
        super(message);
    }
}
