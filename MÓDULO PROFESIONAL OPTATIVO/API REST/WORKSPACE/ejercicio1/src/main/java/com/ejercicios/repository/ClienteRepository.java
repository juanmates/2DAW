package com.ejercicios.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejercicios.modelo.Cliente;

public interface ClienteRepository  extends JpaRepository<Cliente, Integer>{

	
}
