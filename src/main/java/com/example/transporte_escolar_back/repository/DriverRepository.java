package com.example.transporte_escolar_back.repository;

import com.example.transporte_escolar_back.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface DriverRepository extends JpaRepository<Driver, Long> {

    Optional<Driver> findByCnh(String cnh);
    boolean existsByCnh(String cnh);

    @Procedure(name = "Driver.insertDriver")
    void insertDriver(
            @Param("p_name") String name,
            @Param("p_telephone") String telephone,
            @Param("p_cnh") String cnh,
            @Param("p_vehiclePlate") String vehiclePlate
    );
}
