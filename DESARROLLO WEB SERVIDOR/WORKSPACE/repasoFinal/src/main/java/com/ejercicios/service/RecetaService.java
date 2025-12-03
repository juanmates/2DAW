package com.ejercicios.service;

import java.util.List;

import com.ejercicios.modelo.Receta;

public interface RecetaService {
	
	
	// CRUD
	void crearReceta(Receta e);
	List<Receta> leerRecetas();
	void eliminarReceta(Receta e);
	Receta actualizarReceta(Receta e);

}
