package com.demater.core.usecase.account.exception;

public class AccountTypeNotFoundException extends RuntimeException {
    public AccountTypeNotFoundException(String message) {
        super(message);
    }
}
