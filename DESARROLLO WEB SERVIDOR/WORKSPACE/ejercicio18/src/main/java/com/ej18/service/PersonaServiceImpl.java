package com.ej18.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ej18.model.Pasaporte;
import com.ej18.model.Persona;
import com.ej18.model.Proyecto;
import com.ej18.repository.PersonaRepository;

@Service
public class PersonaServiceImpl implements PersonaService {

	@Autowired
    private PersonaRepository personaRepository;

   

    @Override
    public Persona guardarPersona(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public List<Persona> obtenerTodos() {
        return personaRepository.findAll();
    }

    @Override
    public Optional<Persona> obtenerPorId(Long id) {
        return personaRepository.findById(id);
    }

    @Override
    public void asignarPasaporte(Persona persona, Pasaporte pasaporte) {
        persona.setPasaporte(pasaporte);
        personaRepository.save(persona);
    }

    @Override
    public void agregarProyecto(Persona persona, Proyecto proyecto) {
        persona.agregarProyecto(proyecto);
        personaRepository.save(persona);
    }

    @Override
    public void eliminarProyecto(Persona persona, Proyecto proyecto) {
        persona.eliminarProyecto(proyecto);
        personaRepository.save(persona);
    }
}
