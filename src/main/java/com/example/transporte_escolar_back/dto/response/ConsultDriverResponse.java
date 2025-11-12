package com.example.transporte_escolar_back.dto.response;

import com.example.transporte_escolar_back.model.Driver;

import java.util.Optional;

public record ConsultDriverResponse(
        boolean success,
        String message,
        Optional<Driver> driver
){}
