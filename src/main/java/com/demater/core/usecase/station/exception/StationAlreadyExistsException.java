package com.demater.core.usecase.station.exception;

public class StationAlreadyExistsException extends RuntimeException {
    public StationAlreadyExistsException(String message) {
        super(message);
    }
}
