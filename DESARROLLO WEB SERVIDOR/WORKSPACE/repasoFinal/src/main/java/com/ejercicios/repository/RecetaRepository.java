package com.ejercicios.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejercicios.modelo.Receta;

public interface RecetaRepository extends JpaRepository<Receta, Integer>{
	Optional<Receta> findTopByOrderByPuntuacionDesc();
}
