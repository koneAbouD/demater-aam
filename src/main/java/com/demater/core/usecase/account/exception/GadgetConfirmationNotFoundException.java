package com.demater.core.usecase.account.exception;

public class GadgetConfirmationNotFoundException extends RuntimeException {
    public GadgetConfirmationNotFoundException(String message) {
        super(message);
    }
}
