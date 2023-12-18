package com.demater.core.usecase.account.exception;

public class GadgetAlreadyExistsException extends RuntimeException {
    public GadgetAlreadyExistsException(String message) {
        super(message);
    }
}
