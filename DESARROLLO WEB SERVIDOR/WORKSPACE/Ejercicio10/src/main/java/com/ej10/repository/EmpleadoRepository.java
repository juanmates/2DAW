package com.ej10.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ej10.model.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {
    List<Empleado> findByPuesto(String puesto);
    
   // Integer countByOficinaId(Integer id);
}
