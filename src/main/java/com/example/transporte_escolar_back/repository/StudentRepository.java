package com.example.transporte_escolar_back.repository;

import com.example.transporte_escolar_back.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
//    Optional<Student> findByCpf(String cpf);
//    boolean existByCpf(String cpf);
}
