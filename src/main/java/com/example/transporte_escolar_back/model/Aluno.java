package com.example.transporte_escolar_back.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Column;
import java.time.LocalTime;

@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAluno;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false)
    private Integer idade;

    @Column(nullable = false)
    private LocalTime horarioPartidaAluno;

    @Column(nullable = false)
    private LocalTime horarioChegadaAluno;

    @Column(nullable = false, length = 10)
    private String numero; // Número da casa/apartamento

    // --- Relacionamentos FK ---

    @ManyToOne
    @JoinColumn(name = "id_escola", nullable = false)
    private Escola escola;

    @ManyToOne
    @JoinColumn(name = "id_responsavel", nullable = false)
    private Responsavel responsavel;

    @ManyToOne
    @JoinColumn(name = "id_turno", nullable = false)
    private Turno turno;

    @ManyToOne
    @JoinColumn(name = "id_endereco", nullable = false)
    private Endereco endereco; // Endereço de residência/coleta

    // Construtores, Getters e Setters (Omissos para brevidade)
}
