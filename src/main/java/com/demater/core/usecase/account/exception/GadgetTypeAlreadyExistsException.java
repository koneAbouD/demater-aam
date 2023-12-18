package com.demater.core.usecase.account.exception;

public class GadgetTypeAlreadyExistsException extends RuntimeException {
    public GadgetTypeAlreadyExistsException(String message) {
        super(message);
    }
}
