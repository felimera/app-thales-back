package com.projectthales.model.entity;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeEntity {
    private Integer id;
    private String employee_name;
    private Double employee_salary;
    private Integer employee_age;
    private String profile_image;
}
