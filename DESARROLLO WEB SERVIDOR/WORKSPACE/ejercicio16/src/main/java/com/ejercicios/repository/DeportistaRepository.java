package com.ejercicios.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejercicios.modelo.Deportista;

public interface DeportistaRepository extends JpaRepository<Deportista, Integer>{
	

}
