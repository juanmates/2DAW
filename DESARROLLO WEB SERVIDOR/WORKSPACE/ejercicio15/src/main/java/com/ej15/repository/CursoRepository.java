package com.ej15.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ej15.model.Curso;


public interface CursoRepository extends JpaRepository<Curso, Integer> {
    List<Curso> findByNombreContainingIgnoreCase(String palabra);
}