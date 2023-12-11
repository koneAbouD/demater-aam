package com.demater.rest.admin.exception;

import com.demater.core.usecase.admin.exception.AdminDeletingException;
import com.demater.core.usecase.auth.exception.UserAlreadyExistsException;
import com.demater.core.usecase.common.exception.AdminCreatingException;
import com.demater.core.usecase.common.exception.RoleNotFoundException;
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
public class AdminExceptionHandler extends ResponseEntityExceptionHandler {
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

    @ExceptionHandler(value = {AdminCreatingException.class})
    @ResponseStatus(value = FORBIDDEN)
    @ApiResponse(responseCode = "403", description = "Can't create or update user, It doesn't have enough rights",
            content = {@Content(mediaType = "application/json")})
    ResponseEntity<APIsOut> handle(AdminCreatingException ex) {
        return new ResponseEntity<>(new APIsOut(false, ex.getMessage()), FORBIDDEN);
    }

    @ExceptionHandler(value = {AdminDeletingException.class})
    @ResponseStatus(value = FORBIDDEN)
    @ApiResponse(responseCode = "403", description = "Can't delete user, It doesn't have enough rights", content = {@Content(mediaType = "application/json")})
    ResponseEntity<APIsOut> handle(AdminDeletingException ex) {
        return new ResponseEntity<>(new APIsOut(false, ex.getMessage()), FORBIDDEN);
    }
}
