package com.ejercicios.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejercicios.modelo.Vehiculo;

public interface VehiculoRepository extends JpaRepository<Vehiculo, Long>{

}
