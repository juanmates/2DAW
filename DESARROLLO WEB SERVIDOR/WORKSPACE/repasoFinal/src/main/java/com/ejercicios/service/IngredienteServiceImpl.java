package com.ejercicios.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejercicios.modelo.Ingrediente;
import com.ejercicios.repository.IngredienteRepository;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class IngredienteServiceImpl implements IngredienteService {

    @Autowired
	IngredienteRepository ingredienteRepository;

    @Override
    public List<Ingrediente> findAll() {
        return ingredienteRepository.findAll();
    }

    @Override
    public Optional<Ingrediente> findById(Long id) {
        return ingredienteRepository.findById(id);
    }

    @Override
    public Ingrediente save(Ingrediente ingrediente) {
        return ingredienteRepository.save(ingrediente);
    }

    @Override
    public void deleteById(Long id) {
        ingredienteRepository.deleteById(id);
    }

    @Override
    public List<Ingrediente> findByCaloriasGreaterThan(Integer calorias) {
        return ingredienteRepository.findByCaloriasGreaterThan(calorias);
    }
}

