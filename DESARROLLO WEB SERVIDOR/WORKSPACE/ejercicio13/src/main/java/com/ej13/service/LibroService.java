package com.ej13.service;

import java.util.List;

import com.ej13.model.Libro;



public interface LibroService {
    List<Libro> obtenerTodosLibros();
   
    Libro actualizarTituloLibro(Integer libroId, String nuevoTitulo);
   
}