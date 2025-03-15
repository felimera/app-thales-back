package com.projectthales.model.dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private Integer id;
    private String name;
    private Double salary;
    private Integer age;
    private String image;
    private Double employeeAnnualSalary;
}
