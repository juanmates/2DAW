package com.ejercicio14.service;

import java.util.List;

import com.ejercicio14.model.Estudiante;

public interface EstudianteService {

	List<Estudiante> obtenerTodos();

	Estudiante obtener(Integer id);

	String obtenerEmail(Integer id);

	List<Estudiante> obtenerNombreCadena(String cadena);

}
