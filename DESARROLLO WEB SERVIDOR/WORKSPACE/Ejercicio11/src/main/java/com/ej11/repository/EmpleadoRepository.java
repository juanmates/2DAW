package com.ej11.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ej11.model.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {
    List<Empleado> findByPuesto(String puesto);
    
}
