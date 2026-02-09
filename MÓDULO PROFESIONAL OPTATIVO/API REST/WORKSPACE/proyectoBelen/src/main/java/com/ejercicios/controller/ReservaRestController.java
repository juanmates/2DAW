package com.ejercicios.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ejercicios.modelo.Reserva;
import com.ejercicios.servicio.ReservaService;

@RestController
@RequestMapping("/api/reservas")
@CrossOrigin(origins = "*")
public class ReservaRestController {

	@Autowired
	private ReservaService servicio;

	@PostMapping
	public ResponseEntity<Reserva> crearActualizar(@RequestBody Reserva entidad) {
		Reserva guardada = servicio.crearActualizarReserva(entidad);
		return new ResponseEntity<>(guardada, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Reserva>> listarTodas() {
		return ResponseEntity.ok(servicio.listarTodasLasReservar());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Reserva> buscarPorId(@PathVariable Long id) {
		Reserva r = servicio.buscarReservaSegunId(id);
		return (r != null) ? ResponseEntity.ok(r) : ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Long id) {
		servicio.eliminarReservaSegunId(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/usuario/{idUsuario}")
	public ResponseEntity<List<Reserva>> buscarPorUsuario(@PathVariable Long idUsuario) {
		return ResponseEntity.ok(servicio.buscarPorUsuario(idUsuario));
	}

	@GetMapping("/buscar/fecha/{fecha}")
	public ResponseEntity<List<Reserva>> buscarPorFecha(
			@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {
		return ResponseEntity.ok(servicio.buscarPorFecha(fecha));
	}

	@DeleteMapping("/cancelar/usuario/{idUsuario}")
	public ResponseEntity<Void> cancelarReservasUsuario(@PathVariable Long idUsuario) {
		servicio.cancelarLaReservaDeUsuario(idUsuario);
		return ResponseEntity.noContent().build();
	}
}
