package com.hrudesh.taxcalculator.controller;

import com.hrudesh.taxcalculator.advice.EmplyeeNotFoundException;
import com.hrudesh.taxcalculator.dto.EmployeeResponse;
import com.hrudesh.taxcalculator.model.Employee;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public interface EmployeeController {

    @PostMapping("/employee")
    ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee);

    @GetMapping(value = "/tax-calulator/{employeeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<EmployeeResponse> getEmployeeTaxInformation(@PathVariable Long employeeId) throws EmplyeeNotFoundException;
}
