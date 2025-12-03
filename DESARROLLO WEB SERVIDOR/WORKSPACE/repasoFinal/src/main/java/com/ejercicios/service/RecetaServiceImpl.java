package com.ejercicios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ejercicios.modelo.Receta;
import com.ejercicios.repository.RecetaRepository;

public class RecetaServiceImpl implements RecetaService{
	
	@Autowired
	private RecetaRepository repositorio;

	@Override
	public void crearReceta(Receta e) {
		// TODO Auto-generated method stub
		repositorio.save(e);
	}

	@Override
	public List<Receta> leerRecetas() {
		// TODO Auto-generated method stub
		return repositorio.findAll();
	}

	@Override
	public void eliminarReceta(Receta e) {
		// TODO Auto-generated method stub
		repositorio.delete(e);
	}

	@Override
	public Receta actualizarReceta(Receta e) {
		// TODO Auto-generated method stub
		return repositorio.save(e);
	}

}
