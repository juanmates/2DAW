package com.ejercicios.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.ejercicios.modelo.Deporte;

public interface DeporteRepository extends JpaRepository<Deporte, Integer>{

	
	
}
