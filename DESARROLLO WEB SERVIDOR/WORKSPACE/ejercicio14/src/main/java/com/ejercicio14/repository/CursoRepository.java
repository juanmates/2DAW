package com.ejercicio14.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejercicio14.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer> {

	List<Curso> findByCursoContaining(String palabra);

}
