package com.demater.rest.station.exception;

import com.demater.core.domain.exception.CityNotFoundException;
import com.demater.core.domain.exception.InsufficientGadgetException;
import com.demater.core.domain.exception.UnavailableGadgetException;
import com.demater.core.usecase.station.exception.StationAlreadyExistsException;
import com.demater.core.usecase.station.exception.StationNotFoundException;
import com.demater.rest.common.out.APIsOut;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.*;

@ControllerAdvice
public class StationExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {StationAlreadyExistsException.class})
    @ResponseStatus(value = CONFLICT)
    @ApiResponse(responseCode = "409", description = "Station already exists", content = {@Content(mediaType = "application/json")})
    ResponseEntity<APIsOut> handle(StationAlreadyExistsException ex) {
        return new ResponseEntity<>(new APIsOut(false, ex.getMessage()), CONFLICT);
    }

    @ExceptionHandler(value = {StationNotFoundException.class})
    @ResponseStatus(value = NOT_FOUND)
    @ApiResponse(responseCode = "404", description = "Station not found", content = {@Content(mediaType = "application/json")})
    ResponseEntity<APIsOut> handle(StationNotFoundException ex) {
        return new ResponseEntity<>(new APIsOut(false, ex.getMessage()), NOT_FOUND);
    }

    @ExceptionHandler(value = {InsufficientGadgetException.class})
    @ResponseStatus(value = BAD_REQUEST)
    @ApiResponse(responseCode = "400", description = "Station not found", content = {@Content(mediaType = "application/json")})
    ResponseEntity<APIsOut> handle(InsufficientGadgetException ex) {
        return new ResponseEntity<>(new APIsOut(false, ex.getMessage()), BAD_REQUEST);
    }

    @ExceptionHandler(value = {UnavailableGadgetException.class})
    @ResponseStatus(value = BAD_REQUEST)
    @ApiResponse(responseCode = "400", description = "Station not found", content = {@Content(mediaType = "application/json")})
    ResponseEntity<APIsOut> handle(UnavailableGadgetException ex) {
        return new ResponseEntity<>(new APIsOut(false, ex.getMessage()), BAD_REQUEST);
    }

    @ExceptionHandler(value = {CityNotFoundException.class})
    @ResponseStatus(value = NOT_FOUND)
    @ApiResponse(responseCode = "404", description = "City not found", content = {@Content(mediaType = "application/json")})
    ResponseEntity<APIsOut> handle(CityNotFoundException ex) {
        return new ResponseEntity<>(new APIsOut(false, ex.getMessage()), NOT_FOUND);
    }
}
