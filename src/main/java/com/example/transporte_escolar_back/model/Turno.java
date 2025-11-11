package com.example.transporte_escolar_back.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import java.time.LocalTime;

@Entity
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTurno;

    @Column(nullable = false, length = 50)
    private String nomeRota;

    @Column(nullable = false)
    private LocalTime horarioInicioServico;

    @Column(nullable = false)
    private LocalTime horarioFimServico;

    // Construtores, Getters e Setters (Omissos para brevidade)
}