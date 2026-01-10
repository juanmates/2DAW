package com.ej10.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.ej10.model.Oficina;

public interface OficinaRepository extends JpaRepository<Oficina, Integer> {
}