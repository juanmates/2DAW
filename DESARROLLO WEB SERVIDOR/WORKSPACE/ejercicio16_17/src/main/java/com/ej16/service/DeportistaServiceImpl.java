package com.ej16.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ej16.model.Deportista;
import com.ej16.model.Deporte;
import com.ej16.repository.DeportistaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class DeportistaServiceImpl implements DeportistaService {
	@Autowired
	private DeportistaRepository deportistaRepository;

	@Override
	public Deportista crearDeportista(Deportista deportista) {
		return deportistaRepository.save(deportista);
	}

	@Override
	public List<Deportista> obtenerTodos() {
		return deportistaRepository.findAll();
	}

	@Override
	public Deportista obtenerPorId(Integer id) {
		return deportistaRepository.findById(id).orElse(null);
	}

	@Override
	public void agregarDeporte(Integer deportistaId, Deporte deporte) {
		Deportista deportista = obtenerPorId(deportistaId);
		if (deportista != null) {
			deportista.agregarDeporte(deporte);
			deportistaRepository.save(deportista);
		}
	}

	@Override
	public void eliminarDeporte(Integer deportistaId, Deporte deporte) {
		Deportista deportista = obtenerPorId(deportistaId);
		if (deportista != null) {
			deportista.eliminarDeporte(deporte);
			deportistaRepository.save(deportista);
		}
	}

}
