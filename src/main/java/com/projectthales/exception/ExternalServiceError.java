package com.projectthales.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExternalServiceError extends RuntimeException {
    private final String code;
    private final String status;

    public ExternalServiceError(String message, String code, String status) {
        super(message);
        this.code = code;
        this.status = status;
    }
}
