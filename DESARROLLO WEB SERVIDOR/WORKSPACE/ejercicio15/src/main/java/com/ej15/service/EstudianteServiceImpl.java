package com.ej15.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ej15.model.Estudiante;
import com.ej15.repository.EstudianteRepository;

import jakarta.transaction.Transactional;

@Service
public class EstudianteServiceImpl implements EstudianteService {

	@Autowired
	private EstudianteRepository estudianteRepository;

	@Override
	public List<Estudiante> obtenerTodos() {
		return estudianteRepository.findAll();
	}

	@Override
	public Estudiante obtenerPorId(Integer id) {
		Optional<Estudiante> estudiante = estudianteRepository.findById(id);
		if (estudiante.isPresent()) {
			return estudiante.get();
		} 
		return null;
	}

	@Override
	public Estudiante actualizarEmail(Integer id, String nuevoEmail) {
		Optional<Estudiante> estOpt = estudianteRepository.findById(id);
		if (estOpt.isPresent()) {
			Estudiante estudiante = estOpt.get();
			estudiante.setEmail(nuevoEmail);
			return estudianteRepository.save(estudiante);
		}
		return null;
	}

	@Override
	public List<Estudiante> buscarPorNombre(String cadena) {
		return estudianteRepository.findByNombreContainingIgnoreCase(cadena);
	}
}
