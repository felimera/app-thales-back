package com.projectthales.model.builder;

import com.projectthales.model.dto.EmployeeDto;
import com.projectthales.model.entity.EmployeeEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeDtoBuilder {
    private Integer id;
    private String employeeName;
    private Double employeeSalary;
    private Integer employeeAge;
    private String profileImage;
    private Double employeeAnnualSalary;

    private EmployeeDtoBuilder toEmployeeDtoBuilder() {
        return EmployeeDtoBuilder
                .builder()
                .id(1)
                .employeeName("Name Test")
                .employeeSalary(124000.0)
                .employeeAge(45)
                .profileImage("image test")
                .build();
    }

    public EmployeeDto toEmployeeEntity() {
        EmployeeDtoBuilder builder = toEmployeeDtoBuilder();
        return new EmployeeDto(
                builder.id,
                builder.employeeName,
                builder.employeeSalary,
                builder.employeeAge,
                builder.profileImage,
                builder.employeeAnnualSalary
        );
    }

    public EmployeeDto toEditId(Integer id) {
        EmployeeDtoBuilder builder = toEmployeeDtoBuilder();
        return new EmployeeDto(
                id,
                builder.employeeName,
                builder.employeeSalary,
                builder.employeeAge,
                builder.profileImage,
                builder().employeeAnnualSalary
        );
    }
}
