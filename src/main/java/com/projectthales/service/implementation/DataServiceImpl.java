package com.projectthales.service.implementation;

import com.google.gson.Gson;
import com.projectthales.mapper.EmployeeMapper;
import com.projectthales.model.dto.EmployeeDto;
import com.projectthales.model.entity.ResponseEmployeeEntity;
import com.projectthales.model.entity.ResponseListEmployeesEntity;
import com.projectthales.service.IDataService;
import com.projectthales.util.UtilJson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class DataServiceImpl implements IDataService {

    @Override
    public List<EmployeeDto> getDataList() {
        String url = "https://dummy.restapiexample.com/api/v1/employees";
        String jsonResponse = UtilJson.getJsonResponse(url);
        Gson gson = new Gson();
        ResponseListEmployeesEntity respuesta = gson.fromJson(jsonResponse, ResponseListEmployeesEntity.class);

        log.info(respuesta.toString());
        if (respuesta.getData() != null) {
            return respuesta.getData().stream().map(EmployeeMapper.INSTANCE::toDto).toList();
        }
        return new ArrayList<>();
    }

    @Override
    public EmployeeDto getById(Integer id) {
        String url = "https://dummy.restapiexample.com/api/v1/employee/" + id;
        String jsonResponse = UtilJson.getJsonResponse(url);
        Gson gson = new Gson();
        ResponseEmployeeEntity respuesta = gson.fromJson(jsonResponse, ResponseEmployeeEntity.class);

        log.info(respuesta.toString());
        if (respuesta.getData() != null) {
            return EmployeeMapper.INSTANCE.toDto(respuesta.getData());
        }
        return null;
    }
}
