package com.ej16.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ej16.model.Deporte;
import com.ej16.repository.DeporteRepository;
import com.ej16.repository.DeportistaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class DeporteServiceImpl implements DeporteService {

	@Autowired
	private DeporteRepository deporteRepository;
	
    @Override
    public Deporte crearDeporte(Deporte deporte) {
        return deporteRepository.save(deporte);
    }

    @Override
    public List<Deporte> obtenerTodos() {
        return deporteRepository.findAll();
    }

    @Override
    public Deporte obtenerPorId(Long id) {
        return deporteRepository.findById(id).orElse(null);
    }
}