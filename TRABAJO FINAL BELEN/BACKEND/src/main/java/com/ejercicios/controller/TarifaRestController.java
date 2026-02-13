package com.ejercicios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ejercicios.modelo.Tarifa;
import com.ejercicios.servicio.TarifaService;

@RestController
@RequestMapping("/api/tarifas")
@CrossOrigin(origins = "http://localhost:4200")
public class TarifaRestController {

	@Autowired
	private TarifaService servicio;

	@PostMapping
	public ResponseEntity<Tarifa> crearActualizar(@RequestBody Tarifa entidad) {
		Tarifa guardada = servicio.crearActualizarTarifa(entidad);
		return new ResponseEntity<>(guardada, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Tarifa>> listarTodas() {
		return ResponseEntity.ok(servicio.listarTodasLasTarifas());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Tarifa> buscarPorId(@PathVariable Long id) {
		Tarifa t = servicio.buscarTarifaPorId(id);
		return (t != null) ? ResponseEntity.ok(t) : ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Long id) {
		servicio.eliminarTarifaSegunid(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/buscar/permiso/{permiso}")
	public ResponseEntity<List<Tarifa>> buscarPorPermiso(@PathVariable String permiso) {
		List<Tarifa> lista = servicio.buscarPorTipoPermiso(permiso);
		return ResponseEntity.ok(lista);
	}

	// Ejemplo de uso: /api/tarifas/presupuesto/5?numClases=20
	@GetMapping("/presupuesto/{idTarifa}")
	public ResponseEntity<Double> calcularPresupuesto(
			@PathVariable Long idTarifa, 
			@RequestParam Integer numClases) {
		
		Double total = servicio.calcularPresupuestoEstimado(idTarifa, numClases);
		return ResponseEntity.ok(total);
	}
}