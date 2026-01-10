package com.ej16.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ej16.model.Deportista;
import com.ej16.model.Deporte;

public interface DeportistaService {

    Deportista crearDeportista(Deportista deportista);
    List<Deportista> obtenerTodos();
    Deportista obtenerPorId(Integer id);
    void agregarDeporte(Integer deportistaId, Deporte deporte);
    void eliminarDeporte(Integer deportistaId, Deporte deporte);
}