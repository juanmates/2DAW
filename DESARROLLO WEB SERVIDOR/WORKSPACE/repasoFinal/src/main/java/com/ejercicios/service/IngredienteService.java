package com.ejercicios.service;

import java.util.List;
import java.util.Optional;

import com.ejercicios.modelo.Ingrediente;

public interface IngredienteService {
	
	List<Ingrediente> findAll();

	Optional<Ingrediente> findById(Long id);

	Ingrediente save(Ingrediente ingrediente);

	void deleteById(Long id);

	List<Ingrediente> findByCaloriasGreaterThan(Integer calorias);


}
