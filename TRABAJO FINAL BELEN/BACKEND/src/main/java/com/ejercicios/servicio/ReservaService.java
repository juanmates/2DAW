package com.ejercicios.servicio;

import java.time.LocalDate;
import java.util.List;

import com.ejercicios.modelo.Reserva;

public interface ReservaService {
	
	/////////////////////////////////////////////////////
	
	//			CRUD

	Reserva crearActualizarReserva(Reserva entidad);
	
	List<Reserva> listarTodasLasReservar();
	
	Reserva buscarReservaSegunId(Long id);
	
	void eliminarReservaSegunId(Long id);
	
	/////////////////////////////////////////////////////

	//Listar todas las reservas de un alumno especifico
	List<Reserva> buscarPorUsuario(Long idUsuario);
	
	//Buscar reservas programadas para una fecha concreta
	List<Reserva> buscarPorFecha(LocalDate fecha);
	
	// Cancelar una reserva de un alumno
	void cancelarLaReservaDeUsuario(Long idUsuario);
}
