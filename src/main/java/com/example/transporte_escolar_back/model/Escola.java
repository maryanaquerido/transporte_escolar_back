package com.example.transporte_escolar_back.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Column;

@Entity
public class Escola {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEscola;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 10)
    private String numero;

    // Relacionamento ManyToOne com Endereco
    @ManyToOne
    @JoinColumn(name = "id_endereco", nullable = false)
    private Endereco endereco;

    // Construtores, Getters e Setters (Omissos para brevidade)
}