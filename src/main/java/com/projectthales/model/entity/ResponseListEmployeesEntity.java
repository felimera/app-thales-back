package com.projectthales.model.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
public class ResponseListEmployeesEntity {
    private String status;
    private List<EmployeeEntity> data = new ArrayList<>();
    private String message;
}
