package com.demater.core.usecase.gadget.exception;

public class GadgetAlreadyExistsException extends RuntimeException {
    public GadgetAlreadyExistsException(String message) {
        super(message);
    }
}
