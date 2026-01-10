package com.ej13.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ej13.model.Libro;



public interface LibroRepository extends JpaRepository<Libro, Integer> {
    List<Libro> findByTitulo(String titulo);
}
