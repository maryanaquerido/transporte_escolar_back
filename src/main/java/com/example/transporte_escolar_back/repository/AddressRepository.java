package com.example.transporte_escolar_back.repository;

import com.example.transporte_escolar_back.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
