package com.workintech.spring17challenge.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ApiErrorResponse> handleException(ApiException exception) {
        ApiErrorResponse apiErrorResponse = new ApiErrorResponse(exception.getHttpStatus().value(), exception.getMessage(), System.currentTimeMillis());
        log.error("Exception occured: ", exception);
        return new ResponseEntity<>(apiErrorResponse, exception.getHttpStatus());
    }

    @ExceptionHandler
    public ResponseEntity<ApiErrorResponse> handleException(Exception exception) {
        ApiErrorResponse apiErrorResponse = new ApiErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getMessage(), System.currentTimeMillis());
        log.error("Unknown occured: ", exception);
        return new ResponseEntity<>(apiErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
