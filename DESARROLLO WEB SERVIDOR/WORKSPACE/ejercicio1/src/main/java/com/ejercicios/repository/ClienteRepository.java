package com.ejercicios.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ejercicios.modelo.Cliente;

public interface ClienteRepository  extends JpaRepository<Cliente, Integer>{
	
	
	List<Cliente> findByNombreContainingIgnoreCase(String nombre);
	
	@Query("SELECT c FROM Cliente c WHERE c.nombre = :nombre AND c.apellidos = :apellidos")
	List<Cliente> buscarPorNombreYApellidos(@Param("nombre") String nombre, @Param("apellidos") String
	apellidos);
	
	@Query("SELECT c FROM Cliente c ORDER BY c.apellidos ASC")
	List<Cliente> ordenPorApellidos();
	
	@Query("SELECT COUNT(c) FROM Cliente c WHERE c.nombre = :nombre")
	long contarPorNombre(@Param("nombre") String nombre);
	
	@Query("SELECT c FROM Cliente c WHERE c.nombre LIKE 'prefijo%' AND c.apellidos LIKE '%sufijo'")
	List<Cliente> prefijoSufijo(@Param("nombre") String prefijo, @Param("apellidos") String
	apellidos);
	
	


	
	
}
