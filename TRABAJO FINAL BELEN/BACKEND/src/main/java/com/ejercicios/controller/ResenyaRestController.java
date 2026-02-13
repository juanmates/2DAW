package com.ejercicios.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ejercicios.modelo.Resenya;
import com.ejercicios.servicio.ResenyaService;

@RestController
@RequestMapping("/api/resenyas")
@CrossOrigin(origins = "http://localhost:4200")
public class ResenyaRestController {

	@Autowired
	private ResenyaService servicio;

	@PostMapping
	public ResponseEntity<Resenya> crearActualizar(@RequestBody Resenya entidad) {
		Resenya guardada = servicio.crearActualizarResenya(entidad);
		// Retornamos 201 Created para nuevas inserciones o actualizaciones exitosas
		return new ResponseEntity<>(guardada, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Resenya>> listarTodas() {
		List<Resenya> lista = servicio.listarTodasLasResenyas();
		return ResponseEntity.ok(lista);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Resenya> buscarPorId(@PathVariable Long id) {
		Resenya r = servicio.buscarResenyaPorId(id);
		return (r != null) ? ResponseEntity.ok(r) : ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Long id) {
		servicio.eliminarResenyaSegunId(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/autoescuela/{idAutoescuela}")
	public ResponseEntity<List<Resenya>> buscarPorAutoescuela(@PathVariable Long idAutoescuela) {
		List<Resenya> lista = servicio.buscarResenyasPorAutoescuela(idAutoescuela);
		return ResponseEntity.ok(lista);
	}

	@GetMapping("/usuario/{idUsuario}")
	public ResponseEntity<List<Resenya>> buscarPorUsuario(@PathVariable Long idUsuario) {
		List<Resenya> lista = servicio.buscarResenyasPorUsuario(idUsuario);
		return ResponseEntity.ok(lista);
	}

	@GetMapping("/recuento/autoescuela/{idAutoescuela}")
	public ResponseEntity<Map<Double, Integer>> obtenerRecuento(@PathVariable Long idAutoescuela) {
		Map<Double, Integer> recuento = servicio.obtenerRecuentoPorPuntuacion(idAutoescuela);
		// Si el mapa está vacío, devolvemos 200 OK con el mapa vacío (o podrías elegir 204)
		return ResponseEntity.ok(recuento);
	}
}