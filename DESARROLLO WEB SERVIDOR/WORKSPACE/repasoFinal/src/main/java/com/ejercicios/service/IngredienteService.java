package com.ejercicios.service;

import java.util.List;

import com.ejercicios.modelo.Ingrediente;

public interface IngredienteService {
	
	void crearIngrediente(Ingrediente e);
	List<Ingrediente> leerIngredientes();
	void eliminarIngrediente(Ingrediente e);
	Ingrediente actualizarIngrediente(Ingrediente ingrediente);
	

}
