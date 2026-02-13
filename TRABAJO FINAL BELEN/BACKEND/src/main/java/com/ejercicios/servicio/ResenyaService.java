package com.ejercicios.servicio;

import java.util.List;
import java.util.Map;

import com.ejercicios.modelo.Resenya;

public interface ResenyaService {

	/////////////////////////////////////////////////////
	
	//				CRUD

	Resenya crearActualizarResenya(Resenya entidad);
	
	List<Resenya> listarTodasLasResenyas();
	
	Resenya buscarResenyaPorId(Long id);
	
	void eliminarResenyaSegunId(Long id);
	
	/////////////////////////////////////////////////////

	// Listar todas las reseñas de una autoescuela específica
	List<Resenya> buscarResenyasPorAutoescuela(Long idAutoescuela);
	
	// Listar todas las reseñas realizadas por un usuario concreto
	List<Resenya> buscarResenyasPorUsuario(Long idUsuario);
	
	// Obtener un resumen de cuántas reseñas hay por cada puntuación
	// Ej: "5 estrellas: 10 reseñas"
	Map<Double, Integer> obtenerRecuentoPorPuntuacion(Long idAutoescuela);
}
