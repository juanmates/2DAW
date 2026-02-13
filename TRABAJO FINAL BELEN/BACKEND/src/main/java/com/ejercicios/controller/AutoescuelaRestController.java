package com.ejercicios.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ejercicios.modelo.Autoescuela;
import com.ejercicios.modelo.Resenya;
import com.ejercicios.modelo.Tarifa;
import com.ejercicios.servicio.AutoescuelaService;

@RestController
@RequestMapping("/api/autoescuelas")
@CrossOrigin(origins = "http://localhost:4200")
public class AutoescuelaRestController {

	@Autowired
	private AutoescuelaService servicio;

	@PostMapping
	public ResponseEntity<Autoescuela> crearActualizar(@RequestBody Autoescuela entidad) {
		Autoescuela guardada = servicio.crearActualizarAutoescuela(entidad);
		return new ResponseEntity<>(guardada, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Autoescuela>> listarTodas() {
		List<Autoescuela> lista = servicio.listarTodasLasAutoescuelas();
		return ResponseEntity.ok(lista);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Autoescuela> buscarPorId(@PathVariable Long id) {
		Autoescuela a = servicio.buscarAutoescuelaPorId(id);
		return (a != null) ? ResponseEntity.ok(a) : ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Long id) {
		servicio.eliminarAutoescuelaSegunId(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/buscar/ciudad/{ciudad}")
	public ResponseEntity<List<Autoescuela>> buscarPorCiudad(@PathVariable String ciudad) {
		return ResponseEntity.ok(servicio.buscarPorCiudad(ciudad));
	}

	@GetMapping("/{id}/precio-minimo")
	public ResponseEntity<Double> obtenerPrecioMinimo(@PathVariable Long id) {
		return ResponseEntity.ok(servicio.obtenerPrecioMinimo(id));
	}

	@GetMapping("/{id}/puntuacion-media")
	public ResponseEntity<Double> calcularMedia(@PathVariable Long id) {
		return ResponseEntity.ok(servicio.calcularPuntuacionMedia(id));
	}

	@GetMapping("/buscar/cp/{cp}")
	public ResponseEntity<List<Autoescuela>> buscarPorCP(@PathVariable String cp) {
		return ResponseEntity.ok(servicio.buscarPorCodigoPostal(cp));
	}

	@GetMapping("/{id}/contar-vehiculos/{tipo}")
	public ResponseEntity<Long> contarVehiculos(@PathVariable Long id, @PathVariable String tipo) {
		return ResponseEntity.ok(servicio.contarVehiculosPorPermiso(id, tipo));
	}

	@GetMapping("/{id}/tarifas/{permiso}")
	public ResponseEntity<List<Tarifa>> obtenerTarifas(@PathVariable Long id, @PathVariable String permiso) {
		return ResponseEntity.ok(servicio.obtenerTarifasPorPermiso(id, permiso));
	}

	@GetMapping("/{id}/tiene-vehiculos")
	public ResponseEntity<Boolean> tieneVehiculos(@PathVariable Long id) {
		return ResponseEntity.ok(servicio.tieneVehiculosResgistrados(id));
	}

	@GetMapping("/{id}/resenyas-criticas")
	public ResponseEntity<List<Resenya>> obtenerCriticas(@PathVariable Long id) {
		return ResponseEntity.ok(servicio.obtenerResenyasCriticas(id));
	}

	@GetMapping("/{id}/mejor-comentario")
	public ResponseEntity<Resenya> obtenerMejor(@PathVariable Long id) {
		Resenya r = servicio.obtenerMejorComentario(id);
		return (r != null) ? ResponseEntity.ok(r) : ResponseEntity.noContent().build();
	}

	@GetMapping("/{id}/mapa-permisos")
	public ResponseEntity<Map<String, Set<String>>> obtenerMapa(@PathVariable Long id) {
		return ResponseEntity.ok(servicio.obtenerMapaPermisosPorNombre(id));
	}
}