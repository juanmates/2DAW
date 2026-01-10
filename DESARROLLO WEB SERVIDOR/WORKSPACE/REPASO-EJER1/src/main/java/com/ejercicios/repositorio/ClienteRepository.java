package com.ejercicios.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ejercicios.modelo.Cliente;

public class ClienteRepository extends JpaRepository<Cliente, Integer>{

	
	
}
