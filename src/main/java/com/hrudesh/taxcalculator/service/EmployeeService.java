package com.hrudesh.taxcalculator.service;

import com.hrudesh.taxcalculator.advice.EmplyeeNotFoundException;
import com.hrudesh.taxcalculator.dto.EmployeeResponse;
import com.hrudesh.taxcalculator.model.Employee;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {

    Employee saveEmployee(Employee employee);

    EmployeeResponse getEmployeeTaxInformation(Long employeeId) throws EmplyeeNotFoundException;
}
