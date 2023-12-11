package com.demater.core.usecase.gadget.exception;

public class GadgetTypeNotFoundException extends RuntimeException {
    public GadgetTypeNotFoundException(String message) {
        super(message);
    }
}
