package com.projectthales.service;

import com.projectthales.model.dto.EmployeeDto;

import java.util.List;

public interface IEmployeeService {
    List<EmployeeDto> getDataList();

    EmployeeDto getById(Integer id);
}
