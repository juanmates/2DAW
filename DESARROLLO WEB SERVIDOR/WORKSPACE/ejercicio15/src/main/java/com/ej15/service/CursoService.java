package com.ej15.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ej15.model.Curso;
import com.ej15.model.Estudiante;


@Service
public interface CursoService {
	 Curso crearCurso(Curso curso);
	    Curso agregarEstudiante(Integer cursoId, Integer estudianteId);
	    Curso eliminarEstudiante(Integer cursoId, Integer estudianteId);
	    List<Curso> obtenerTodos();
	    Curso obtenerPorId(Integer id);
	    List<Curso> buscarPorNombre(String palabra);
	    void eliminarCurso(Integer id);

}
