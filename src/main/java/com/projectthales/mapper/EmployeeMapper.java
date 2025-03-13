package com.projectthales.mapper;

import com.projectthales.model.dto.EmployeeDto;
import com.projectthales.model.entity.EmployeeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper {

    EmployeeMapper INSTANCE= Mappers.getMapper(EmployeeMapper.class);
    @Mapping(target = "name",source = "employee_name")
    @Mapping(target = "salary",source = "employee_salary")
    @Mapping(target = "age",source = "employee_age")
    @Mapping(target = "image",source = "profile_image")
    EmployeeDto toDto(EmployeeEntity employeeEntity);
}
