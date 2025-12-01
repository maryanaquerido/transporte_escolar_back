package com.example.transporte_escolar_back.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "shift")
public class Shift {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idShift;

    @Column(nullable = false, length = 50)
    private String routeName;

    @Column(nullable = false)
    private LocalTime startShift;

    @Column(nullable = false)
    private LocalTime endShift;
}