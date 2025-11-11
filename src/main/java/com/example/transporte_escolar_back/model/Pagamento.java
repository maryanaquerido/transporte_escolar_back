package com.example.transporte_escolar_back.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Column;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPagamento;

    @ManyToOne
    @JoinColumn(name = "id_aluno", nullable = false)
    private Aluno aluno;

    @Column(nullable = false)
    private LocalDate mesReferencia;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal valorContratado;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal valorPago;

    @Column(nullable = false)
    private LocalDate dataVencimento;

    private LocalDate dataPagamento; // Pode ser NULL se não foi pago

    @Column(nullable = false, length = 20)
    private String status; // Ex: "Pago", "Pendente"

    // Construtores, Getters e Setters (Omissos para brevidade)
}