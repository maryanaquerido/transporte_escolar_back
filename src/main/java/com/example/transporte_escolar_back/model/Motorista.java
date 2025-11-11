package com.example.transporte_escolar_back.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity
public class Motorista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMotorista;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 20)
    private String telefone;

    @Column(nullable = false, length = 30)
    private String cnh;

    @Column(nullable = false, length = 10)
    private String placaVeiculo;

    // Construtores, Getters e Setters (Omissos para brevidade)
}