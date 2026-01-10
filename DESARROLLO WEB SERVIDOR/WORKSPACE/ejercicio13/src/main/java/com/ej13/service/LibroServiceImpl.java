package com.ej13.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ej13.model.Libro;
import com.ej13.repository.LibroRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class LibroServiceImpl implements LibroService {

	@Autowired
	private LibroRepository libroRepo;

	@Override
	public List<Libro> obtenerTodosLibros() {
		return libroRepo.findAll();
	}

	@Override
	public Libro actualizarTituloLibro(Integer libroId, String nuevoTitulo) {
		Libro libro = libroRepo.findById(libroId).orElse(null);
		if (libro != null) {
			libro.setTitulo(nuevoTitulo);
			return libroRepo.save(libro);
		}
		return null;
	}

}
