package com.hrudesh.taxcalculator.service;

import com.hrudesh.taxcalculator.advice.EmplyeeNotFoundException;
import com.hrudesh.taxcalculator.dao.EmployeeDao;
import com.hrudesh.taxcalculator.dto.EmployeeResponse;
import com.hrudesh.taxcalculator.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeDao.save(employee);
    }

    @Override
    public EmployeeResponse getEmployeeTaxInformation(Long employeeId) throws EmplyeeNotFoundException {
        Optional<Employee> emp = employeeDao.get(employeeId);
        if (!emp.isPresent()) {
            System.out.println("Employee with employeeId not found: " + employeeId);
            throw new EmplyeeNotFoundException("Employee with employeeId not found: " + employeeId);

        }
        Employee employee = emp.get();
        BigDecimal annualSalary = annualSalary(employee);
        //total tax
        BigDecimal tax = taxCalculate(annualSalary);
        //2% cess for salary more than 2500000
        BigDecimal totalCess = cessAmount(annualSalary);
        //total tax with 2% cess added to it
        System.out.println("Outsied all calculations");
        BigDecimal totalTax = tax.add(totalCess);
        totalTax = totalTax.setScale(2, RoundingMode.HALF_UP);
        EmployeeResponse employeeResponse = new EmployeeResponse();
        System.out.println("Outsied all calculations");
        employeeResponse.setEmployeeCode(employee.getEmployeeId());
        employeeResponse.setFirstName(employee.getFirstName());
        employeeResponse.setLastName(employee.getLastName());
        System.out.println("Outsied all calculations");
        employeeResponse.setYearlySalary(annualSalary);
        System.out.println("Outsied all calculations");
        employeeResponse.setCessAmount(totalCess);
        System.out.println("Outsied all calculations final");
        employeeResponse.setTaxAmount(totalTax);
        System.out.println("Outsied all calculations2");
        return employeeResponse;
    }

    private BigDecimal annualSalary(Employee employee) {
        BigDecimal monthlySalary = employee.getSalary();
        LocalDate joiningDate = employee.getDoj();
        LocalDate yearEndDate = LocalDate.of(2024, 3, 31);
        int daysLeftInJoiningMonth = 30 - joiningDate.getDayOfMonth();
        System.out.println("Days Left in month: "+daysLeftInJoiningMonth);
        BigDecimal salaryPerDay = monthlySalary.divide(new BigDecimal(30), 2, RoundingMode.HALF_UP);
        int monthsLeft = 12 - joiningDate.getMonthValue();
        long monthsBetween = ChronoUnit.MONTHS.between(joiningDate.withDayOfMonth(1), yearEndDate.withDayOfMonth(1));
        System.out.println("Months between: "+monthsBetween);
        BigDecimal totalMonthsSalary = monthlySalary.multiply(new BigDecimal(monthsLeft));
        System.out.println("Full months salary: "+totalMonthsSalary);
        BigDecimal partialMonthSalary = salaryPerDay.multiply(new BigDecimal(daysLeftInJoiningMonth));
        System.out.println("Partial month salary: "+partialMonthSalary);
        BigDecimal annualSalary = totalMonthsSalary.add(partialMonthSalary);
        annualSalary = annualSalary.setScale(2, RoundingMode.HALF_UP);
        System.out.println("Annual salary: "+annualSalary);
        return annualSalary;
    }

    private BigDecimal taxCalculate(BigDecimal totalSalary) {
        BigDecimal salary = totalSalary;
        BigDecimal tax = BigDecimal.ZERO;
        System.out.println("Before tax: "+tax);

        BigDecimal slab1 = new BigDecimal("250000");
        BigDecimal slab2 = new BigDecimal("500000");
        BigDecimal slab3 = new BigDecimal("1000000");

        BigDecimal rate1 = new BigDecimal("0.00");
        BigDecimal rate2 = new BigDecimal("0.05");
        BigDecimal rate3 = new BigDecimal("0.10");
        BigDecimal rate4 = new BigDecimal("0.20");

        if (salary.compareTo(slab1) > 0) {
            tax = tax.add(slab1.multiply(rate1));
            System.out.println("Tax slab 1: "+tax);
            salary = salary.subtract(slab1);
        }
        if (salary.compareTo(slab2) > 0) {
            tax = tax.add(slab2.multiply(rate2));
            System.out.println("Tax slab 2: "+tax);
            salary = salary.subtract(slab2);
        }
        if (salary.compareTo(slab3) > 0) {
            tax = tax.add(slab3.multiply(rate3));
            System.out.println("Tax slab 3: "+tax);
            salary = salary.subtract(slab3);
        }
        if (salary.compareTo(slab3) > 0) {
            tax = tax.add(salary.multiply(rate4));
            System.out.println("Tax slab 4: "+tax);
        }
        tax = tax.setScale(2, RoundingMode.HALF_UP);
        System.out.println("Returning Tax: "+tax);
        return tax;
    }

    private BigDecimal cessAmount(BigDecimal totalSalary) {
        BigDecimal totalCess = BigDecimal.ZERO;
        System.out.println("Before total cess: "+totalCess);
        BigDecimal minSal = new BigDecimal("2500000");
        if (totalSalary.compareTo(minSal) > 0) {
            BigDecimal percentage = new BigDecimal("0.02");
            totalCess = totalSalary.multiply(percentage);
        }
        totalCess = totalCess.setScale(2, RoundingMode.HALF_UP);
        System.out.println("Return total cess: "+totalCess);
        return totalCess;
    }
}
