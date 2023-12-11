package com.demater.rest.common.exception;

import com.demater.core.usecase.common.exception.CSVFormatErrorException;
import com.demater.rest.common.out.APIsOut;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.EXPECTATION_FAILED;

@ControllerAdvice
public class FileUploadExceptionAdvice extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {MaxUploadSizeExceededException.class})
    @ResponseStatus(value = EXPECTATION_FAILED)
    @ApiResponse(responseCode = "417", description = "File to upload size exceeded", content = {@Content(mediaType = "application/json")})
    ResponseEntity<APIsOut> handleMaxSizeException(MaxUploadSizeExceededException ex) {
        return new ResponseEntity<>(new APIsOut(false, ex.getMessage()), EXPECTATION_FAILED);
    }

    @ExceptionHandler(value = {CSVFormatErrorException.class})
    @ResponseStatus(value = BAD_REQUEST)
    @ApiResponse(responseCode = "400", description = "Can't import station, CSV error format", content = {@Content(mediaType = "application/json")})
    ResponseEntity<APIsOut> handle(CSVFormatErrorException ex) {
        return new ResponseEntity<>(new APIsOut(false, ex.getMessage()), BAD_REQUEST);
    }
}
