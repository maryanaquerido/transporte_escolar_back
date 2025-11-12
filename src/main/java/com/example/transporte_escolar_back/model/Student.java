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
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStudent;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false)
    private Integer birthDate;

    @Column(nullable = false)
    private LocalTime studentDepartureTime;

    @Column(nullable = false)
    private LocalTime studentArrivalTime;

    // --- Relacionamentos FK ---
    @ManyToOne
    @JoinColumn(name = "id_school", nullable = false)
    private School school;

    @ManyToOne
    @JoinColumn(name = "id_responsible", nullable = false)
    private Responsible responsible;

    @ManyToOne
    @JoinColumn(name = "id_address", nullable = false)
    private Address studentAddress;

    //    @ManyToOne
    //    @JoinColumn(name = "id_turno", nullable = false)
    //    private Turno turno;
}
