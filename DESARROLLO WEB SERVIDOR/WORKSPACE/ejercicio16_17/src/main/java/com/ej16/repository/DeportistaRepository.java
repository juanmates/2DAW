package com.ej16.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ej16.model.Deportista;
import com.ej16.model.Deporte;

import jakarta.transaction.Transactional;

@Repository
public interface DeportistaRepository extends JpaRepository<Deportista, Integer> {
}