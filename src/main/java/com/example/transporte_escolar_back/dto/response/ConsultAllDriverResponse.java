package com.example.transporte_escolar_back.dto.response;

import java.util.List;

public record ConsultAllDriverResponse(
        boolean success,
        String message,
        List<DriverResponse> drivers
) {}
