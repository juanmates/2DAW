package com.ej13.service;

import java.util.List;

import com.ej13.model.Autor;
import com.ej13.model.Libro;

import jakarta.transaction.Transactional;

public interface AutorService {

	// 1. Obtener todos los autores
	List<Autor> obtenerAutores();

	// 2. Obtener autor por ID
	Autor obtenerAutor(Integer id);

	// 3. Insertar nuevo autor
	Autor insertarAutor(Autor autor);

	// 4. Actualizar autor
	Autor actualizarAutor(Autor autor);

	// 5. Eliminar autor por ID
	void eliminarAutor(Integer id);

	// 6. Añadir libro a un autor
	Libro añadirLibro(Integer autorId, Libro libro);

	// 7. Eliminar libro de un autor
	void eliminarLibro(Integer autorId, Integer libroId);

	// 8. Obtener libros de un autor
	List<Libro> obtenerLibrosAutor(Integer autorId);

	// 11. Obtener autores cuyo nombre contenga una cadena
	List<Autor> autoresPorNombre(String cadena);

	// 12. Actualizar nombre de autores que tengan libro con título específico
	void actualizarNombreAutoresPorLibro(String tituloLibro, String nuevoNombre);

}
