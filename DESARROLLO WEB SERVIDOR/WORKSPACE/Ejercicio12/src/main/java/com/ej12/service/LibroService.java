package com.ej12.service;

import java.util.List;

import com.ej12.model.Libro;

public interface LibroService {
    List<Libro> obtenerTodosLibros();
   
    Libro actualizarTituloLibro(Integer libroId, String nuevoTitulo);
   
}