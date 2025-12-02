package com.example.transporte_escolar_back.dto.response;

public record DriverResponse(
        Long id,
        String name,
        String telephone,
        String cnh,
        String vehiclePlate
) {}
