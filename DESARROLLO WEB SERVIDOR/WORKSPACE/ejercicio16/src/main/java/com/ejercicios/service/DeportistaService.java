package com.ejercicios.service;

import java.util.List;

import com.ejercicios.modelo.Deporte;
import com.ejercicios.modelo.Deportista;

public interface DeportistaService {
	
	Deportista crearDeportista(Deportista d);
	List<Deportista> listarTodosLosDeportistas();
	void eliminarDeportista(int id);
	Boolean añadirDeporteADeportista(Integer id, Deporte de);
	Deportista buscarDeportista(int id);
	void quitarDeporteDeDeportista(Deporte de);
	Deportista actualizarDeportista(Deportista de);
	

}
