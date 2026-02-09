package com.ejercicios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ejercicios.modelo.Usuario;
import com.ejercicios.servicio.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioRestController {

	@Autowired
	private UsuarioService servicio;

	@PostMapping
	public ResponseEntity<Usuario> crearActualizar(@RequestBody Usuario entidad) {
		Usuario guardado = servicio.crearActualizarUsuario(entidad);
		return new ResponseEntity<>(guardado, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Usuario>> listarTodos() {
		return ResponseEntity.ok(servicio.listarTodosLosUsuarios());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Usuario> buscarPorId(@PathVariable Long id) {
		Usuario u = servicio.buscarUsuarioPorId(id);
		return (u != null) ? ResponseEntity.ok(u) : ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Long id) {
		// Mantengo el nombre del método de tu interfaz
		servicio.eliminarAutoescuelaSegunId(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/buscar/email")
	public ResponseEntity<Usuario> buscarPorEmail(@RequestParam String email) {
		Usuario u = servicio.buscarPorEmail(email);
		return (u != null) ? ResponseEntity.ok(u) : ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}/cambiar-password")
	public ResponseEntity<Boolean> cambiarPassword(
			@PathVariable Long id, 
			@RequestParam String antigua, 
			@RequestParam String nueva) {
		
		Boolean resultado = servicio.cambiarPassword(id, antigua, nueva);
		return resultado ? ResponseEntity.ok(true) : ResponseEntity.badRequest().body(false);
	}

	@GetMapping("/{id}/nombre-completo")
	public ResponseEntity<String> obtenerNombre(@PathVariable Long id) {
		String nombre = servicio.obtenerNombreCompleto(id);
		return ResponseEntity.ok(nombre);
	}
}
