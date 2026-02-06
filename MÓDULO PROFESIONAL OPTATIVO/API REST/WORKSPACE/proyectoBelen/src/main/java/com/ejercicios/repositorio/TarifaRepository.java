package com.ejercicios.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejercicios.modelo.Tarifa;

public interface TarifaRepository extends JpaRepository<Tarifa, Long>{

}
