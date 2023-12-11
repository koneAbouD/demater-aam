package com.demater.core.usecase.gadget.exception;

public class GadgetConfirmationNotFoundException extends RuntimeException {
    public GadgetConfirmationNotFoundException(String message) {
        super(message);
    }
}
