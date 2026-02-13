package com.ejercicios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ejercicios.modelo.Direccion;
import com.ejercicios.servicio.DireccionService;

@RestController
@RequestMapping("/api/direcciones")
@CrossOrigin(origins = "http://localhost:4200")
public class DireccionRestController {

	@Autowired
	private DireccionService servicio;

	@PostMapping
	public ResponseEntity<Direccion> crearActualizar(@RequestBody Direccion entidad) {
		Direccion guardada = servicio.crearActualizarDireccion(entidad);
		return new ResponseEntity<>(guardada, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Direccion>> listarTodas() {
		return ResponseEntity.ok(servicio.listarTodasLasDirecciones());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Direccion> buscarPorId(@PathVariable Long id) {
		Direccion d = servicio.buscarDireccionPorId(id);
		return (d != null) ? ResponseEntity.ok(d) : ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Long id) {
		servicio.eliminarDireccionSegunId(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/{id}/formato")
	public ResponseEntity<String> obtenerDireccionFormateada(@PathVariable Long id) {
		String formateada = servicio.obtenerDireccionFormateada(id);
		// Si el servicio devuelve un mensaje de error o null, podrías manejarlo aquí
		return ResponseEntity.ok(formateada);
	}

	@GetMapping("/filtro/provincia/{provincia}")
	public ResponseEntity<List<Direccion>> filtrarPorProvincia(@PathVariable String provincia) {
		List<Direccion> lista = servicio.fitrarPorProvincia(provincia);
		return ResponseEntity.ok(lista);
	}

	@GetMapping("/filtro/cp-rango")
	public ResponseEntity<List<Direccion>> buscarPorRangoCP(
			@RequestParam String inicio, 
			@RequestParam String fin) {
		List<Direccion> lista = servicio.buscarPorRangoCP(inicio, fin);
		return ResponseEntity.ok(lista);
	}

	@GetMapping("/{id}/autoescuela-asociada")
	public ResponseEntity<String> obtenerNombreAutoescuela(@PathVariable Long id) {
		String nombre = servicio.obtenerNombreAutoescuelaAsociada(id);
		return ResponseEntity.ok(nombre);
	}
}
