package com.hrudesh.taxcalculator.dao;

import com.hrudesh.taxcalculator.model.Employee;
import com.hrudesh.taxcalculator.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EmployeeDao implements DAO<Employee> {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Optional<Employee> get(Long id) {
        return employeeRepository.findById(id);
    }
}
