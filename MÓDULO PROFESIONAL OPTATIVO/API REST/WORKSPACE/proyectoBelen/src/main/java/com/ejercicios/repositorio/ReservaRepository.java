package com.ejercicios.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejercicios.modelo.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long>{

}
