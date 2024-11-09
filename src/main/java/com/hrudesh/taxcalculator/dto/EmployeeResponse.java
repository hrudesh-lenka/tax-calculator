package com.hrudesh.taxcalculator.dto;

import java.math.BigDecimal;

public class EmployeeResponse {

    public EmployeeResponse() {
    }

    public EmployeeResponse(Long employeeCode, String firstName, String lastName, BigDecimal yearlySalary, BigDecimal taxAmount, BigDecimal cessAmount) {
        this.employeeCode = employeeCode;
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearlySalary = yearlySalary;
        this.taxAmount = taxAmount;
        this.cessAmount = cessAmount;
    }

    private Long employeeCode;

    private String firstName;

    private String lastName;

    private BigDecimal yearlySalary;

    private BigDecimal taxAmount;

    private BigDecimal cessAmount;

    public Long getEmployeeCode() {
        return employeeCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public BigDecimal getYearlySalary() {
        return yearlySalary;
    }

    public BigDecimal getTaxAmount() {
        return taxAmount;
    }

    public BigDecimal getCessAmount() {
        return cessAmount;
    }

    public void setEmployeeCode(Long employeeCode) {
        this.employeeCode = employeeCode;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setYearlySalary(BigDecimal yearlySalary) {
        this.yearlySalary = yearlySalary;
    }

    public void setTaxAmount(BigDecimal taxAmount) {
        this.taxAmount = taxAmount;
    }

    public void setCessAmount(BigDecimal cessAmount) {
        this.cessAmount = cessAmount;
    }


    @Override
    public String toString() {
        return "EmployeeResponse{" +
                "employeeCode=" + employeeCode +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", yearlySalary=" + yearlySalary +
                ", taxAmount=" + taxAmount +
                ", cessAmount=" + cessAmount +
                '}';
    }
}
