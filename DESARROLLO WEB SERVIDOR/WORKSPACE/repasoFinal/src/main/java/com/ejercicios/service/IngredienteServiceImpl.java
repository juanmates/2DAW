package com.ejercicios.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejercicios.modelo.Ingrediente;
import com.ejercicios.repository.IngredienteRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class IngredienteServiceImpl implements IngredienteService{
	
	@Autowired
	private IngredienteRepository repositorio;

	@Override
	public void crearIngrediente(Ingrediente e) {
		repositorio.save(e);		
	}

	@Override
	public List<Ingrediente> leerIngredientes() {
		return repositorio.findAll();
		
	}

	@Override
	public void eliminarIngrediente(Ingrediente e) {
		repositorio.delete(e);
		
	}

	@Override
	public Ingrediente actualizarIngrediente(Ingrediente ingrediente) {
		// TODO Auto-generated method stub
		return repositorio.save(ingrediente);	
	}


}
