package com.ej11.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ej11.model.Oficina;

public interface OficinaRepository extends JpaRepository<Oficina, Integer> {

    // Encuentra oficinas por ubicación exacta
    List<Oficina> findByUbicacion(String ubicacion);

    // Encuentra oficinas por número de teléfono
    List<Oficina> findByTelefono(String telefono);

}
