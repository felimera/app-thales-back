package com.projectthales.service;

import com.projectthales.model.dto.DataDto;

import java.util.List;

public interface IDataService {
    List<DataDto> getDataList();

    DataDto getById(Integer id);
}
