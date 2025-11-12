package com.example.transporte_escolar_back.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import java.time.LocalTime;

@Entity
public class Shift {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idShift;

    @Column(nullable = false, length = 50)
    private String routeName;

    @Column(nullable = false)
    private LocalTime startShift;

    @Column(nullable = false)
    private LocalTime endShift;
}