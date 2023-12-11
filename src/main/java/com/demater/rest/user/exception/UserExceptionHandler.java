package com.demater.rest.user.exception;

import com.demater.core.usecase.auth.exception.UserAlreadyActivatedException;
import com.demater.core.usecase.auth.exception.UserAlreadyExistsException;
import com.demater.core.usecase.common.exception.RoleNotFoundException;
import com.demater.core.usecase.common.exception.UserNotActivatedException;
import com.demater.core.usecase.common.exception.UserNotFoundException;
import com.demater.rest.common.out.APIsOut;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice
public class UserExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {UserAlreadyExistsException.class})
    @ResponseStatus(value = CONFLICT)
    @ApiResponse(responseCode = "409", description = "User already exists", content = {@Content(mediaType = "application/json")})
    ResponseEntity<APIsOut> handle(UserAlreadyExistsException ex) {
        return new ResponseEntity<>(new APIsOut(false, ex.getMessage()), CONFLICT);
    }

    @ExceptionHandler(value = {RoleNotFoundException.class})
    @ResponseStatus(value = NOT_FOUND)
    @ApiResponse(responseCode = "404", description = "User roles not found", content = {@Content(mediaType = "application/json")})
    ResponseEntity<APIsOut> handle(RoleNotFoundException ex) {
        return new ResponseEntity<>(new APIsOut(false, ex.getMessage()), NOT_FOUND);
    }

    @ExceptionHandler(value = {UserNotFoundException.class})
    @ResponseStatus(value = NOT_FOUND)
    @ApiResponse(responseCode = "404", description = "User roles not found", content = {@Content(mediaType = "application/json")})
    ResponseEntity<APIsOut> handle(UserNotFoundException ex) {
        return new ResponseEntity<>(new APIsOut(false, ex.getMessage()), NOT_FOUND);
    }

    @ExceptionHandler(value = {UserNotActivatedException.class})
    @ResponseStatus(value = BAD_REQUEST)
    @ApiResponse(responseCode = "400", description = "Bad request for user not activated", content = {@Content(mediaType = "application/json")})
    ResponseEntity<APIsOut> handle(UserNotActivatedException ex) {
        return new ResponseEntity<>(new APIsOut(false, ex.getMessage()), BAD_REQUEST);
    }

    @ExceptionHandler(value = {UserAlreadyActivatedException.class})
    @ResponseStatus(value = BAD_REQUEST)
    @ApiResponse(responseCode = "400", description = "Bad request for user already activated", content = {@Content(mediaType = "application/json")})
    ResponseEntity<APIsOut> handle(UserAlreadyActivatedException ex) {
        return new ResponseEntity<>(new APIsOut(false, ex.getMessage()), BAD_REQUEST);
    }
}
