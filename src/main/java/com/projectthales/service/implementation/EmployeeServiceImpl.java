package com.projectthales.service.implementation;

import com.google.gson.Gson;
import com.projectthales.exception.ExternalServiceError;
import com.projectthales.exception.NotFoundException;
import com.projectthales.mapper.EmployeeMapper;
import com.projectthales.model.compent.ResponseCode;
import com.projectthales.model.dto.EmployeeDto;
import com.projectthales.model.entity.EmployeeEntity;
import com.projectthales.model.entity.ResponseEmployeeEntity;
import com.projectthales.model.entity.ResponseListEmployeesEntity;
import com.projectthales.repository.IEmployeeRepository;
import com.projectthales.service.IEmployeeService;
import com.projectthales.util.UtilBusiness;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class EmployeeServiceImpl implements IEmployeeService {

    private IEmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(IEmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Value("${service.url.externo}")
    private String url;

    @Override
    public List<EmployeeDto> getEmployeeList() {
        String jsonResponse = employeeRepository.getEmployeeJsonResponse(url);
        Gson gson = new Gson();
        ResponseListEmployeesEntity respuesta = gson.fromJson(jsonResponse, ResponseListEmployeesEntity.class);

        log.info(respuesta.toString());
        if (respuesta.getData() != null) {
            return respuesta.getData()
                    .stream()
                    .map(EmployeeServiceImpl::getEmployeeDto)
                    .toList();
        }
        return new ArrayList<>();
    }

    @Override
    public EmployeeDto getById(Integer id) {
        String jsonResponse = employeeRepository.getEmployeeJsonResponse(url + id);
        Gson gson = new Gson();
        ResponseEmployeeEntity respuesta = gson.fromJson(jsonResponse, ResponseEmployeeEntity.class);

        log.info(respuesta.toString());
        if (ResponseCode.SUCCESSFUL_RESPONSE.getCodigo().equals(respuesta.getStatus())) {
            if (Objects.nonNull(respuesta.getData())) {
                return getEmployeeDto(respuesta.getData());
            } else
                throw new NotFoundException(ResponseCode.EMPLOYEE_NOT_FOUND.getMensaje(), ResponseCode.EMPLOYEE_NOT_FOUND.getCodigo());
        } else {
            throw new ExternalServiceError(respuesta.getMessage(), ResponseCode.EXTERNAL_SERVICE_ERROR.getCodigo(), respuesta.getStatus());
        }
    }

    private static EmployeeDto getEmployeeDto(EmployeeEntity employeeEntity) {
        EmployeeDto employeeDto = EmployeeMapper.INSTANCE.toDto(employeeEntity);
        employeeDto.setEmployeeAnnualSalary(UtilBusiness.getAnnualSalaryEmployee(employeeEntity.getEmployee_salary()));
        return employeeDto;
    }
}
