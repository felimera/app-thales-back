package com.projectthales.model.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class EmployeeDto {
    private Integer id;
    private String name;
    private Double salary;
    private Integer age;
    private String image;
    private Double employeeAnnualSalary;
}
