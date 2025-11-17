package com.example.transporte_escolar_back.dto.response;

import com.example.transporte_escolar_back.model.Student;

public record RegisterStudentResponse(
   boolean success,
   String message,
   Student student
){}
