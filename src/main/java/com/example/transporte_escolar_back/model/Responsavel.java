package com.example.transporte_escolar_back.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity
public class Responsavel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idResponsavel;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 30)
    private String parentesco;

    @Column(nullable = false, length = 20)
    private String telefoneContato;

    // Construtores, Getters e Setters (Omissos para brevidade)
}