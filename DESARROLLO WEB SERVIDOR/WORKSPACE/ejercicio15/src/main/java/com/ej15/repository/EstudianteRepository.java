package com.ej15.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.ej15.model.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> {
    List<Estudiante> findByNombreContainingIgnoreCase(String nombre);
}
