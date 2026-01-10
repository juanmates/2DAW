package com.ej13.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ej13.model.Autor;
import com.ej13.model.Libro;
import com.ej13.repository.AutorRepository;
import com.ej13.repository.LibroRepository;

@Service
public class AutorServiceImpl implements AutorService {

	@Autowired
	private AutorRepository autorRepo;

	@Autowired
	private LibroRepository libroRepo;

	// 1. Obtener todos los autores
	public List<Autor> obtenerAutores() {
		return autorRepo.findAll();
	}

	// 2. Obtener autor por ID
	public Autor obtenerAutor(Integer id) {
		return autorRepo.findById(id).orElse(null);
	}

	// 3. Insertar nuevo autor
	public Autor insertarAutor(Autor nombre) {
		return autorRepo.save(nombre);
	}

	// 4. Actualizar autor
	@Override
	public Autor actualizarAutor(Autor autorActualizado) {
		Autor autorExistente = autorRepo.findById(autorActualizado.getId()).orElse(null);
		if (autorExistente != null) {
			autorExistente.setNombre(autorActualizado.getNombre());
			// Si quieres, puedes actualizar también la lista de libros:
			autorExistente.getLibros().clear();
			autorExistente.getLibros().addAll(autorActualizado.getLibros());
			return autorRepo.save(autorExistente);
		}
		return null;
	}

	// 5. Eliminar autor por ID
	public void eliminarAutor(Integer id) {
		autorRepo.deleteById(id);
	}

	// 6. Añadir libro a un autor
	public Libro añadirLibro(Integer autorId, Libro libro) {
		Autor autor = autorRepo.findById(autorId).orElse(null);

		if (autor != null && libro != null) {
			libro.setAutor(autor); // xq es bidireccional
			autor.getLibros().add(libro);
			autorRepo.save(autor); // persiste cambios en la relación
			return libro;
		}
		return null;
	}

	// 7. Eliminar libro de un autor
	public void eliminarLibro(Integer autorId, Integer libroId) {
		Autor autor = autorRepo.findById(autorId).orElse(null);
		if (autor != null) {
			Iterator<Libro> it = autor.getLibros().iterator();
			while (it.hasNext()) {
				Libro libro = it.next();
				if (libro.getId().equals(libroId)) {
					it.remove(); // elimina de forma segura mientras iteramos
					break; // opcional: si solo quieres eliminar el primero que coincida
				}
			}
			autorRepo.save(autor); // persiste los cambios
		}
	}

	// 8. Obtener libros de un autor
	public List<Libro> obtenerLibrosAutor(Integer autorId) {
		Autor autor = autorRepo.findById(autorId).orElse(null);
		if (autor != null) {
			return autor.getLibros();
		}
		return null;
	}

	// 11. Obtener autores cuyo nombre contenga una cadena
	public List<Autor> autoresPorNombre(String cadena) {
		return autorRepo.findByNombreContaining(cadena);
	}

	// 12. Actualizar nombre de autores que tengan libro con título específico
	public void actualizarNombreAutoresPorLibro(String tituloLibro, String nuevoNombre) {
		List<Libro> libros = libroRepo.findByTitulo(tituloLibro);
		for (Libro libro : libros) {
			Autor autor = libro.getAutor();
			if (autor != null) {

				autor.setNombre(nuevoNombre);
				autorRepo.save(autor);
			}
		}
	}

}
