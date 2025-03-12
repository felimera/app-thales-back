package com.projectthales.service.implementation;

import com.google.gson.Gson;
import com.projectthales.model.dto.DataDto;
import com.projectthales.model.dto.ResponseDataDto;
import com.projectthales.model.dto.ResponseListDataDto;
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
    public List<DataDto> getDataList() {
        String url = "https://dummy.restapiexample.com/api/v1/employees";
        String jsonResponse = UtilJson.getJsonResponse(url);
        Gson gson = new Gson();
        ResponseListDataDto respuesta = gson.fromJson(jsonResponse, ResponseListDataDto.class);

        log.info(respuesta.toString());
        if (respuesta.getData() != null) {
            return respuesta.getData();
        }
        return new ArrayList<>();
    }

    @Override
    public DataDto getById(Integer id) {
        String url = "https://dummy.restapiexample.com/api/v1/employee/" + id;
        String jsonResponse = UtilJson.getJsonResponse(url);
        Gson gson = new Gson();
        ResponseDataDto respuesta = gson.fromJson(jsonResponse, ResponseDataDto.class);

        log.info(respuesta.toString());
        if (respuesta.getData() != null) {
            return respuesta.getData();
        }
        return null;
    }
}
