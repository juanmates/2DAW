package com.ej18.service;

import java.util.List;
import java.util.Optional;

import com.ej18.model.Pasaporte;
import com.ej18.model.Persona;
import com.ej18.model.Proyecto;

public interface PersonaService {

    // Guardar o actualizar una persona
    Persona guardarPersona(Persona persona);

    // Obtener todas las personas
    List<Persona> obtenerTodos();

    // Obtener una persona por su ID
    Optional<Persona> obtenerPorId(Long id);

    // Asignar un pasaporte a una persona
    void asignarPasaporte(Persona persona, Pasaporte pasaporte);

    // Agregar un proyecto a una persona
    void agregarProyecto(Persona persona, Proyecto proyecto);

    // Eliminar un proyecto de una persona
    void eliminarProyecto(Persona persona, Proyecto proyecto);
}