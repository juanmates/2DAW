package com.ejercicios.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejercicios.modelo.Autoescuela;

public interface AutoescuelaRepository extends JpaRepository<Autoescuela, Long>{

	List<Autoescuela> findByDireccionCiudadIgnoreCase(String ciudad);
	
}
