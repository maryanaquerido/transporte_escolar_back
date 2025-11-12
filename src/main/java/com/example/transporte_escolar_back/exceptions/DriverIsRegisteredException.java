package com.example.transporte_escolar_back.exceptions;

public class DriverIsRegisteredException extends RuntimeException {
    public DriverIsRegisteredException(String message) {
        super(message);
    }
}
