package com.demater.core.usecase.gadget.exception;

public class GadgetNotFoundException extends RuntimeException {
    public GadgetNotFoundException(String message) {
        super(message);
    }
}
