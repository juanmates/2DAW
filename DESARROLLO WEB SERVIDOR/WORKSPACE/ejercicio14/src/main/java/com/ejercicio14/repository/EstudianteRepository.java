package com.ejercicio14.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejercicio14.model.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> {

	
}
