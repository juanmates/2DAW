package com.ejercicio14.service;

import java.util.List;

import com.ejercicio14.model.Curso;
import com.ejercicio14.model.Estudiante;

public interface CursoService {

	Curso crear(Curso c);

	void añadirEstudiante(Curso c, Estudiante e);

	List<Curso> obtenerCursos();

	Curso obtenerCurso(Integer id);

	List<Curso> obtenerCursosPalabra(String palabra);

	void eliminarEstudiante(Estudiante e);

	void eliminarCurso(Integer id);

}
