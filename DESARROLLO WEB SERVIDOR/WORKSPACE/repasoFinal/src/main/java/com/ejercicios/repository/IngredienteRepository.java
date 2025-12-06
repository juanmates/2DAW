package com.ejercicios.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejercicios.modelo.Ingrediente;

public interface IngredienteRepository extends JpaRepository<Ingrediente, Integer>{

}
