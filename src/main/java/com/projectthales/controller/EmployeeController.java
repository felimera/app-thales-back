package com.projectthales.controller;

import com.projectthales.model.dto.EmployeeDto;
import com.projectthales.service.IEmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Employee", description = "Operations related to employees.")
@RestController
@RequestMapping(path = "/api/v1/employee")
public class EmployeeController {
    private IEmployeeService dataService;

    @Autowired
    public EmployeeController(IEmployeeService dataService) {
        this.dataService = dataService;
    }

    @Operation(summary = "Gets a list of employees.")
    @GetMapping()
    public ResponseEntity<List<EmployeeDto>> getDataList() {
        return ResponseEntity.ok(dataService.getEmployeeList());
    }

    @Operation(summary = "Get an employee by their ID.")
    @GetMapping(path = "/{id}")
    public ResponseEntity<EmployeeDto> getById(@Parameter(description = "Employee ID to search for.") @PathVariable(name = "id") Integer id) {
        return ResponseEntity.ok(dataService.getById(id));
    }
}
