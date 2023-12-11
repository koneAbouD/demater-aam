package com.demater.rest.gadget.exception;

import com.demater.core.usecase.gadget.exception.*;
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
public class GadgetExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {GadgetTypeAlreadyExistsException.class})
    @ResponseStatus(value = CONFLICT)
    @ApiResponse(responseCode = "409", description = "Gadget type already exists", content = {@Content(mediaType = "application/json")})
    ResponseEntity<APIsOut> handle(GadgetTypeAlreadyExistsException ex) {
        return new ResponseEntity<>(new APIsOut(false, ex.getMessage()), CONFLICT);
    }

    @ExceptionHandler(value = {GadgetTypeNotFoundException.class})
    @ResponseStatus(value = NOT_FOUND)
    @ApiResponse(responseCode = "404", description = "Gadget type not found", content = {@Content(mediaType = "application/json")})
    ResponseEntity<APIsOut> handle(GadgetTypeNotFoundException ex) {
        return new ResponseEntity<>(new APIsOut(false, ex.getMessage()), NOT_FOUND);
    }

    @ExceptionHandler(value = {GadgetAlreadyExistsException.class})
    @ResponseStatus(value = CONFLICT)
    @ApiResponse(responseCode = "409", description = "Gadget already exists", content = {@Content(mediaType = "application/json")})
    ResponseEntity<APIsOut> handle(GadgetAlreadyExistsException ex) {
        return new ResponseEntity<>(new APIsOut(false, ex.getMessage()), CONFLICT);
    }

    @ExceptionHandler(value = {GadgetNotFoundException.class})
    @ResponseStatus(value = NOT_FOUND)
    @ApiResponse(responseCode = "404", description = "Gadget don't exists", content = {@Content(mediaType = "application/json")})
    ResponseEntity<APIsOut> handle(GadgetNotFoundException ex) {
        return new ResponseEntity<>(new APIsOut(false, ex.getMessage()), NOT_FOUND);
    }

    @ExceptionHandler(value = {GadgetConfirmationNotFoundException.class})
    @ResponseStatus(value = NOT_FOUND)
    @ApiResponse(responseCode = "404", description = "Gadget confirmation don't exists", content = {@Content(mediaType = "application/json")})
    ResponseEntity<APIsOut> handle(GadgetConfirmationNotFoundException ex) {
        return new ResponseEntity<>(new APIsOut(false, ex.getMessage()), NOT_FOUND);
    }

    @ExceptionHandler(value = {GadgetConfirmationException.class})
    @ResponseStatus(value = BAD_REQUEST)
    @ApiResponse(responseCode = "400", description = "Can't confirm gadget reception", content = {@Content(mediaType = "application/json")})
    ResponseEntity<APIsOut> handle(GadgetConfirmationException ex) {
        return new ResponseEntity<>(new APIsOut(false, ex.getMessage()), BAD_REQUEST);
    }
}
