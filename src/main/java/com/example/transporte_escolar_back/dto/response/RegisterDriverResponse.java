package com.example.transporte_escolar_back.dto.response;

import com.example.transporte_escolar_back.model.Driver;

public record RegisterDriverResponse(
    boolean success,
    String message,
    Driver driver
){}
