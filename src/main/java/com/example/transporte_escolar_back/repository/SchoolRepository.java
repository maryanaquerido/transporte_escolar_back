package com.example.transporte_escolar_back.repository;

import com.example.transporte_escolar_back.model.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School, Long> {
}
