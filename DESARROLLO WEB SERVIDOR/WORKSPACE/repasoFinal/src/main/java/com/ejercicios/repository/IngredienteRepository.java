package com.ejercicios.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejercicios.modelo.Ingrediente;

import java.util.List;

public interface IngredienteRepository extends JpaRepository<Ingrediente, Long> {
	List<Ingrediente> findByCaloriasGreaterThan(Integer calorias);
}
