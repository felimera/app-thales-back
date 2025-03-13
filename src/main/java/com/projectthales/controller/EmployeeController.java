package com.projectthales.controller;

import com.projectthales.model.dto.EmployeeDto;
import com.projectthales.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/employee")
public class EmployeeController {
    private IEmployeeService dataService;

    @Autowired
    public EmployeeController(IEmployeeService dataService) {
        this.dataService = dataService;
    }

    @GetMapping()
    public ResponseEntity<List<EmployeeDto>> getDataList() {
        return ResponseEntity.ok(dataService.getEmployeeList());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<EmployeeDto> getById(@PathVariable(name = "id") Integer id) {
        return ResponseEntity.ok(dataService.getById(id));
    }
}
