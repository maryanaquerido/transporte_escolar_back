package com.example.transporte_escolar_back.dto.response;

import com.example.transporte_escolar_back.model.Driver;

public record UpdateDriverResponse(
    boolean success,
    String message,
    Driver driver
){}
