package com.hrudesh.taxcalculator.controller;

import com.hrudesh.taxcalculator.advice.EmplyeeNotFoundException;
import com.hrudesh.taxcalculator.dto.EmployeeResponse;
import com.hrudesh.taxcalculator.model.Employee;
import com.hrudesh.taxcalculator.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeControllerImpl implements EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Override
    public ResponseEntity<Employee> saveEmployee(Employee employee) {
        return new ResponseEntity<>(employeeService.saveEmployee(employee),HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<EmployeeResponse> getEmployeeTaxInformation(Long employeeId) throws EmplyeeNotFoundException {
        EmployeeResponse employeeResponse = employeeService.getEmployeeTaxInformation(employeeId);
        System.out.println("EmployeeResponse: " + employeeResponse.toString());
        return new ResponseEntity<>(employeeResponse, HttpStatus.OK);
    }
}
