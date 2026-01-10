package com.ej16.service;

import java.util.List;

import com.ej16.model.Deporte;

public interface DeporteService {
    Deporte crearDeporte(Deporte deporte);
    List<Deporte> obtenerTodos();
    Deporte obtenerPorId(Long id);
}
