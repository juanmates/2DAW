package com.ej13.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ej13.model.Autor;

public interface AutorRepository extends JpaRepository<Autor, Integer> {
	List<Autor> findByNombreContaining(String cadena);
}
