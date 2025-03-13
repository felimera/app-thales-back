package com.projectthales.model.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ResponseEmployeeEntity {
    private String status;
    private EmployeeEntity data;
    private String message;
}
