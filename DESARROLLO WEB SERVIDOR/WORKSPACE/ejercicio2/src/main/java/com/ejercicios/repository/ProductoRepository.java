package com.ejercicios.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.ejercicios.modelo.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer>{
	
	List<Producto> findByNombreStartingWithAndPrecioLessThanEqual(String nombre, Float precio);
	
	List<Producto> findByNombreContainingIgnoreCase(String nombre);

	List<Producto> findByPrecioBetween(Float precio1, Float precio2);
	
}
