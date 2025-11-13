package com.example.transporte_escolar_back.dto.request;

public record UpdateDriverRequest(
    String name,
    String telephone,
    String vehiclePlate
){}
