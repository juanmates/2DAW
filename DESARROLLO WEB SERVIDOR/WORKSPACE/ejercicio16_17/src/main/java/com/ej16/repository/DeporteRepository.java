package com.ej16.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ej16.model.Deporte;

@Repository
public interface DeporteRepository extends JpaRepository<Deporte, Long> {
}