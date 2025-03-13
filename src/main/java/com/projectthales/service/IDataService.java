package com.projectthales.service;

import com.projectthales.model.dto.EmployeeDto;

import java.util.List;

public interface IDataService {
    List<EmployeeDto> getDataList();

    EmployeeDto getById(Integer id);
}
