package com.projectthales.model.compent;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ResponseCode {
    SUCCESSFUL_RESPONSE("success", "Successful response to the request."),
    EMPLOYEE_NOT_FOUND("ENF-001", "Employee not found."),
    EXTERNAL_SERVICE_ERROR("ESE-001", "External service error."),
    CONNECTION_ERROR("CONN-003", "Connection error."),
    UNEXPECTED_ERROR("UNE-000", "An unexpected error has occurred.");

    private final String codigo;
    private final String mensaje;
}