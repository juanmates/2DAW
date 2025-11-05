package com.ejercicios.service;

import com.ejercicios.modelo.Deporte;

public interface DeporteService {

	Deporte crearDeporte(Deporte d);
	Deporte buscarDeporte(int id);
	Deporte eliminarDeporte(int id);
	Deporte actualizarDeporte(Deporte d);
	
	
}
