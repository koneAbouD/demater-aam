package com.demater.core.usecase.account.exception;

public class AccountTypeAlreadyExistsException extends RuntimeException {
    public AccountTypeAlreadyExistsException(String message) {
        super(message);
    }
}
