package com.example.transporte_escolar_back.dto.request;

import com.example.transporte_escolar_back.model.Address;
import com.example.transporte_escolar_back.model.Responsible;
import com.example.transporte_escolar_back.model.School;

import java.time.LocalTime;

public record RegisterStudentRequest(
   String name,
   Integer birthDate,
   String cpf,
   LocalTime studentDepartureTime,
   LocalTime studentArrivalTime,
   String schoolName,
   String studentResponsibleCpf,
   String studentCep,
   String studentHouseNumber
){}
