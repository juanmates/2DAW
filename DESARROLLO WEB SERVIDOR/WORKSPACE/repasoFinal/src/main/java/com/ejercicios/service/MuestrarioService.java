package com.ejercicios.service;


import java.util.List;
import java.util.Optional;

import com.ejercicios.modelo.Muestrario;
import com.ejercicios.modelo.Receta;

public interface MuestrarioService {

    List<Muestrario> findAll();

    Optional<Muestrario> findById(Long id);

    Muestrario save(Muestrario muestrario);

    void deleteById(Long id);

    // Asignar receta a muestrario
    Muestrario addReceta(Long muestrarioId, Long recetaId);

    // Quitar receta de muestrario
    Muestrario removeReceta(Long muestrarioId, Long recetaId);

    // Obtener primera receta alfabética del muestrario
    Optional<Receta> findFirstRecetaAlphabetically(Long muestrarioId);
    
    String mostrarRecetasEIngredientes(Long muestrarioId);
}

