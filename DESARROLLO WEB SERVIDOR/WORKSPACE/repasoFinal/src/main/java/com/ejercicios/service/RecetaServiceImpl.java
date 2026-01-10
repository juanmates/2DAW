package com.ejercicios.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejercicios.modelo.Ingrediente;
import com.ejercicios.modelo.Muestrario;
import com.ejercicios.modelo.Receta;
import com.ejercicios.repository.IngredienteRepository;
import com.ejercicios.repository.MuestrarioRepository;
import com.ejercicios.repository.RecetaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RecetaServiceImpl implements RecetaService {

	@Autowired
	RecetaRepository recetaRepository;

	@Autowired
	IngredienteRepository ingredienteRepository;

	@Autowired
	MuestrarioRepository muestrarioRepository;

	@Override
	public List<Receta> findAll() {
		return recetaRepository.findAll();
	}

	@Override
	public Optional<Receta> findById(Long id) {
		return recetaRepository.findById(id);
	}

	@Override
	public Receta save(Receta receta) {
		return recetaRepository.save(receta);
	}

	@Override
	public void deleteById(Long id) {
		recetaRepository.deleteById(id);
	}

	@Override
	public Receta addIngrediente(Long recetaId, Long ingredienteId) {
		Receta receta = recetaRepository.findById(recetaId).orElse(null);
		Ingrediente ingrediente = ingredienteRepository.findById(ingredienteId).orElse(null);
		receta.getIngredientes().add(ingrediente);

		return recetaRepository.save(receta);
	}

	@Override
	public Receta removeIngrediente(Long recetaId, Long ingredienteId) {
		Receta receta = recetaRepository.findById(recetaId).orElse(null);
		Ingrediente ingrediente = ingredienteRepository.findById(ingredienteId).orElse(null);

		if (receta != null) {
			receta.getIngredientes().remove(ingrediente);
			ingrediente.getRecetas().remove(receta);
			return recetaRepository.save(receta);
		}
		return null;
	}

	@Override
	public Receta assignToMuestrario(Long recetaId, Long muestrarioId) {
		Receta receta = recetaRepository.findById(recetaId).orElse(null);
		Muestrario muestrario = muestrarioRepository.findById(muestrarioId).orElse(null);

		if (receta == null || muestrario == null) {
			return null;
		}
		receta.setMuestrario(muestrario);
		muestrario.getRecetas().add(receta);

		return recetaRepository.save(receta);
	}

	@Override
	public Receta removeFromMuestrario(Long recetaId) {
		Receta receta = recetaRepository.findById(recetaId).orElse(null);
		if (receta != null) {
			receta.getMuestrario().getRecetas().remove(receta);
			receta.setMuestrario(null);
			return recetaRepository.save(receta);
		}
		return null;
	}

	@Override
	public Optional<Receta> findTopByOrderByPuntuacionDesc() {
		return recetaRepository.findTopByOrderByPuntuacionDesc();
	}
}
