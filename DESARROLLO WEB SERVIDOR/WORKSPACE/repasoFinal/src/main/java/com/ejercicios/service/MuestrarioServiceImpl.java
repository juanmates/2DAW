package com.ejercicios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ejercicios.modelo.Muestrario;
import com.ejercicios.modelo.Receta;
import com.ejercicios.repository.MuestrarioRepository;
import com.ejercicios.repository.RecetaRepository;

public class MuestrarioServiceImpl implements MuestrarioService{

	@Autowired
	private MuestrarioRepository repositorio;
	private RecetaRepository recetaRepositorio;
	
	@Override
	public void crearMuestrario(Muestrario e) {
		// TODO Auto-generated method stub
		repositorio.save(e);
	}

	@Override
	public List<Muestrario> leerMuestrario() {
		// TODO Auto-generated method stub
		return repositorio.findAll();
	}

	@Override
	public void eliminarMuestrario(Muestrario e) {
		// TODO Auto-generated method stub
		repositorio.delete(e);
	}

	@Override
	public Muestrario actualizarMuestrario(Muestrario e) {
		// TODO Auto-generated method stub
		return repositorio.save(e);
	}

	@Override
	public void AsignarRecetaAMuestrario(Receta receta, Muestrario m) {
		// TODO Auto-generated method stub
		m.getRecetas().add(receta);
		recetaRepositorio.save(receta);
		repositorio.save(m);
	}

}
