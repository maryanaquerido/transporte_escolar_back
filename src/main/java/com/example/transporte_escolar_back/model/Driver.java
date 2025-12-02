package com.example.transporte_escolar_back.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "driver")
@NamedStoredProcedureQuery(
        name = "Driver.insertDriver",
        procedureName = "InsertDriver",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_name", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_telephone", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_cnh", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_vehiclePlate", type = String.class)
        }
)
@NamedStoredProcedureQuery(
        name = "Driver.consultDriverOrdered",
        procedureName = "consultDriverOrdered",
        resultClasses = Driver.class
)
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_driver")
    private Long idDriver;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 20)
    private String telephone;

    @Column(nullable = false, length = 30)
    private String cnh;

    @Column(name = "vehicle_plate", nullable = false, length = 10)
    private String vehiclePlate;
}
