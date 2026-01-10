package com.ejercicios.service;


import java.util.List;
import java.util.Optional;

import com.ejercicios.modelo.Receta;

public interface RecetaService {

    List<Receta> findAll();

    Optional<Receta> findById(Long id);

    Receta save(Receta receta);

    void deleteById(Long id);

    // Asignar ingrediente(s)
    Receta addIngrediente(Long recetaId, Long ingredienteId);
    Receta removeIngrediente(Long recetaId, Long ingredienteId);

    // Asignar a muestrario
    Receta assignToMuestrario(Long recetaId, Long muestrarioId);
    Receta removeFromMuestrario(Long recetaId);

    // Consultas especiales
    Optional<Receta> findTopByOrderByPuntuacionDesc();
}

