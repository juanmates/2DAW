package com.ej18.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ej18.model.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {

}