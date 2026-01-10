package com.ej15.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ej15.model.Estudiante;

@Service
public interface EstudianteService {

	List<Estudiante> obtenerTodos();
    Estudiante obtenerPorId(Integer id);
    Estudiante actualizarEmail(Integer id, String nuevoEmail);
    List<Estudiante> buscarPorNombre(String cadena);

}
