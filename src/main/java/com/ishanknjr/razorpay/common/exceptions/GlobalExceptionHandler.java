package com.ishanknjr.razorpay.common.exceptions;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<ErrorResponse> handleDuplicateResourceException(DuplicateResourceException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT) // 409
                .body(ErrorResponse.of(ex.getErrorcode(), ex.getMessage()));
    }
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(ResourceNotFoundException ex) {

        String errorCode = ex.getResourceName().toUpperCase() + "NOT_FOUND";
        return ResponseEntity.status(HttpStatus.NOT_FOUND) // 404
                .body(ErrorResponse.of(errorCode , ex.getMessage()));
    }


}
