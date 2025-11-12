package com.example.transporte_escolar_back.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity
public class Responsible {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idResponsible;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 30)
    private String kinship;

    @Column(nullable = false, length = 20)
    private String contactNumber;
}