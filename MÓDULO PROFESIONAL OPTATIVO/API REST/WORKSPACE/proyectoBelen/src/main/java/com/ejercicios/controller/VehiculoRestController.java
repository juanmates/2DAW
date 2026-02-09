package com.ejercicios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ejercicios.modelo.Vehiculo;
import com.ejercicios.servicio.VehiculoService;

@RestController
@RequestMapping("/api/vehiculos")
@CrossOrigin(origins = "*")
public class VehiculoRestController {

	@Autowired
	private VehiculoService servicio;

	@PostMapping
	public ResponseEntity<Vehiculo> crearActualizar(@RequestBody Vehiculo entidad) {
		Vehiculo guardado = servicio.crearActualizarVehiculo(entidad);
		return new ResponseEntity<>(guardado, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Vehiculo>> listarTodos() {
		return ResponseEntity.ok(servicio.listarTodosLosVehiculos());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Vehiculo> buscarPorId(@PathVariable Long id) {
		Vehiculo v = servicio.buscarVehiculoPorId(id);
		return (v != null) ? ResponseEntity.ok(v) : ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Long id) {
		servicio.eliminarVehiculoSegunId(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/matricula/{matricula}")
	public ResponseEntity<Vehiculo> buscarPorMatricula(@PathVariable String matricula) {
		Vehiculo v = servicio.buscarPorMatricula(matricula);
		return (v != null) ? ResponseEntity.ok(v) : ResponseEntity.notFound().build();
	}

	@GetMapping("/permiso/{tipoPermiso}")
	public ResponseEntity<List<Vehiculo>> filtrarPorPermiso(@PathVariable String tipoPermiso) {
		List<Vehiculo> lista = servicio.filtrarPorTipoPermiso(tipoPermiso);
		return ResponseEntity.ok(lista);
	}

	@GetMapping("/autoescuelas/asignados")
	public ResponseEntity<List<Vehiculo>> buscarVehiculosConAutoescuela() {
		List<Vehiculo> lista = servicio.buscarVehiculosPorAutoescuela();
		return ResponseEntity.ok(lista);
	}
}