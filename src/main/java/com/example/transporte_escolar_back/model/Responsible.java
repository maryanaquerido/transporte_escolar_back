package com.example.transporte_escolar_back.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "responsible")
public class Responsible {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idResponsible;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 100)
    private  String cpf;

    @Column(nullable = false, length = 30)
    private String kinship;

    @Column(nullable = false, length = 20)
    private String contactNumber;
}