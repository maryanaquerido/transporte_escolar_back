package com.example.transporte_escolar_back.dto.request;

public record RegisterDriverRequest(
    String name,
    String telephone,
    String cnh,
    String vehiclePlate
){}
