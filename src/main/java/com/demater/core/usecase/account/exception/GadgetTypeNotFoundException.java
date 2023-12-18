package com.demater.core.usecase.account.exception;

public class GadgetTypeNotFoundException extends RuntimeException {
    public GadgetTypeNotFoundException(String message) {
        super(message);
    }
}
