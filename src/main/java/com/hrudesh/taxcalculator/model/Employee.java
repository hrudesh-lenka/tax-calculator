package com.hrudesh.taxcalculator.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;

@Entity
@Table(name = "employee")
public class Employee {

    public Employee() {
    }

    public Employee(Long employeeId, BigInteger phoneNumber, String firstName, String lastName, String email, LocalDate doj, BigDecimal salary) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.doj = doj;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
    }

    @Id
    @NotNull(message = "EmployeeId field cannot be empty")
    private Long employeeId;

    @NotNull(message = "FirstName field cannot be empty")
    private String firstName;

    @NotNull(message = "LastName field cannot be empty")
    private String lastName;

    @NotNull(message = "Email field cannot be empty")
    @Email
    private String email;

    private BigInteger phoneNumber;

    @NotNull(message = "Date field cannot be empty")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate doj;

    @NotNull(message = "salary field cannot be empty")
    private BigDecimal salary;

    public @NotNull(message = "EmployeeId field cannot be empty") Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(@NotNull(message = "EmployeeId field cannot be empty") Long employeeId) {
        this.employeeId = employeeId;
    }

    public @NotNull(message = "FirstName field cannot be empty") String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NotNull(message = "FirstName field cannot be empty") String firstName) {
        this.firstName = firstName;
    }

    public @NotNull(message = "LastName field cannot be empty") String getLastName() {
        return lastName;
    }

    public void setLastName(@NotNull(message = "LastName field cannot be empty") String lastName) {
        this.lastName = lastName;
    }

    public @NotNull(message = "Email field cannot be empty") @Email String getEmail() {
        return email;
    }

    public void setEmail(@NotNull(message = "Email field cannot be empty") @Email String email) {
        this.email = email;
    }

    public @NotNull(message = "Date field cannot be empty") LocalDate getDoj() {
        return doj;
    }

    public void setDoj(@NotNull(message = "Date field cannot be empty") LocalDate doj) {
        this.doj = doj;
    }

    public @NotNull(message = "salary field cannot be empty") BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(@NotNull(message = "salary field cannot be empty") BigDecimal salary) {
        this.salary = salary;
    }

    public BigInteger getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(BigInteger phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
