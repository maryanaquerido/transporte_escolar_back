package com.example.transporte_escolar_back.repository;

import com.example.transporte_escolar_back.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DriverRepository extends JpaRepository<Driver, Long> {
    Optional<Driver> findByCnh(String cnh);
    boolean existsByCnh(String cnh);
}
