package com.example.transporte_escolar_back.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPayment;

    @ManyToOne
    @JoinColumn(name = "id_student", nullable = false)
    private Student student;

    @Column(nullable = false)
    private LocalDate referenceMonth;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal contractValue;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal amountPaid;

    @Column(nullable = false)
    private LocalDate dueDate;

    private LocalDate paymentDate; // Pode ser NULL se não foi pago

    @Column(nullable = false, length = 20)
    private String status; // Ex: "Pago", "Pendente"
}