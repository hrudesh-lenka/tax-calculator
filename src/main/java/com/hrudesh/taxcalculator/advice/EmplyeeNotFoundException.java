package com.hrudesh.taxcalculator.advice;

public class EmplyeeNotFoundException extends RuntimeException {
    public EmplyeeNotFoundException(String message) {
        super(message);
    }
}
