package com.ejercicios.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ejercicios.modelo.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
	
	@Modifying // cada vez que sea un update hay que poner modifying
	@Query("UPDATE Cliente c SET c.direccion.ciudad = 'Sevilla' WHERE LOWER(c.nombre) LIKE 'a%'")
	void actualizarCiudadSevillaParaClientesConA();
	
	
	
}
