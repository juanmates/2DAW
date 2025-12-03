package com.ejercicios.service;

import java.util.List;

import com.ejercicios.modelo.Muestrario;
import com.ejercicios.modelo.Receta;

public interface MuestrarioService {
	
	void crearMuestrario(Muestrario e);
	List<Muestrario> leerMuestrario();
	void eliminarMuestrario(Muestrario e);
	Muestrario actualizarMuestrario(Muestrario e);
	void AsignarRecetaAMuestrario(Receta receta, Muestrario m);

}
