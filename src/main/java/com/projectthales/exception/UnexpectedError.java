package com.projectthales.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class UnexpectedError extends RuntimeException{
    private final String code;
    private final HttpStatus httpStatus;

    public UnexpectedError(String message, String code) {
        super(message);
        this.code = code;
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    }
}
