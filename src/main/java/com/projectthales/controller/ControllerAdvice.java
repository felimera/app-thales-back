package com.projectthales.controller;

import com.projectthales.exception.ExternalServiceError;
import com.projectthales.exception.NotFoundException;
import com.projectthales.exception.UnexpectedError;
import com.projectthales.model.exception.ExceptionResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<ExceptionResponseMessage> runtimeExceptionHandler(RuntimeException ex) {
        ExceptionResponseMessage error = ExceptionResponseMessage.builder().code("500").message(ex.getMessage()).build();
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = ExternalServiceError.class)
    public ResponseEntity<ExceptionResponseMessage> externalServiceErrorHandler(ExternalServiceError ex) {
        ExceptionResponseMessage error = ExceptionResponseMessage.builder().code(ex.getCode()).status(ex.getStatus()).message(ex.getMessage()).build();
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<ExceptionResponseMessage> notFoundExceptionHandler(NotFoundException ex) {
        ExceptionResponseMessage error = ExceptionResponseMessage.builder().code(ex.getCode()).status(ex.getHttpStatus().toString()).message(ex.getMessage()).build();
        return new ResponseEntity<>(error, ex.getHttpStatus());
    }

    @ExceptionHandler(value = UnexpectedError.class)
    public ResponseEntity<ExceptionResponseMessage> unexpectedErrorHandler(UnexpectedError ex) {
        ExceptionResponseMessage error = ExceptionResponseMessage.builder().code(ex.getCode()).status(ex.getHttpStatus().toString()).message(ex.getMessage()).build();
        return new ResponseEntity<>(error, ex.getHttpStatus());
    }
}
