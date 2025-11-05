package com.ejercicios.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejercicios.modelo.Deporte;
import com.ejercicios.modelo.Deportista;
import com.ejercicios.repository.DeportistaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class DeportistaServiceImpl implements DeportistaService{
	
	@Autowired
	private DeportistaRepository deportistaRepositorio;
	
	@Override
	public Deportista crearDeportista(Deportista d) {
		deportistaRepositorio.save(d);
		return d;
	}
	@Override
	public List<Deportista> listarTodosLosDeportistas() {
		List<Deportista> res = deportistaRepositorio.findAll();
		return res;
	}
	@Override
	public void eliminarDeportista(int id) {
		deportistaRepositorio.deleteById(id);
		
	}
	@Override
	public Boolean añadirDeporteADeportista(Integer id, Deporte de) {
		Deportista deportista = buscarDeportista(id);
		
		if(deportista != null) {
			deportista.getDeportes().add(de);
			deportistaRepositorio.save(deportista);
			return true;
		}
		return false;
	}
	@Override
	public Deportista buscarDeportista(int id) {
		return deportistaRepositorio.findById(id).orElse(null);
		
	}
	@Override
	public void quitarDeporteDeDeportista(Deporte de) {
		
	}
	@Override
	public Deportista actualizarDeportista(Deportista de) {
		return null;
	}
	

	
	
	

}
