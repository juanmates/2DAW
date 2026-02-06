package com.ejercicios.servicio;

import java.util.List;

import com.ejercicios.modelo.Reserva;

public interface ReservaService {

	Reserva crearActualizarReserva(Reserva entidad);
	
	List<Reserva> listarTodasLasReservar();
	
	Reserva buscarReservaSegunId(Long id);
	
	void eliminarReservaSegunId(Long id);
	
}
