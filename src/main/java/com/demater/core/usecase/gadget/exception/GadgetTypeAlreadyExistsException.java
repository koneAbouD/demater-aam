package com.demater.core.usecase.gadget.exception;

public class GadgetTypeAlreadyExistsException extends RuntimeException {
    public GadgetTypeAlreadyExistsException(String message) {
        super(message);
    }
}
