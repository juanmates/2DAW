package com.examenA.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.examenA.modelo.Entrada;
import com.examenA.servicio.EntradaServicio;



@RestController
@RequestMapping("/api/entradas")
@CrossOrigin(origins="*")
public class EntradaController {
	
	
	@Autowired
	EntradaServicio servicio;
	
	
	@PostMapping()
	private ResponseEntity<Entrada> postComprar(@RequestBody Entrada entrada) {
		Entrada creada =  servicio.crearEntrada(entrada);
		return ResponseEntity.ok(creada);
	}

	@GetMapping()
	public ResponseEntity<List<Entrada>> getEntradas() {
		List<Entrada> entradas = servicio.obtenerEntradas();
		return ResponseEntity.ok(entradas);
	}
	
	@PutMapping()
	public ResponseEntity<Void> actualizarEntrada(@RequestBody Entrada entrada) {
		Entrada actualizada = servicio.actualizarEntrada(entrada.getId(), entrada);
		if(actualizada == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/NoTaquilla")
	public ResponseEntity<List<Entrada>> getEntradasNoTaquilla() {
		List<Entrada> entradasNoTaquilla = servicio.obtenerEntradasNoTaquilla();
		if(entradasNoTaquilla.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(entradasNoTaquilla);
	}
	
	@PatchMapping("/nuevasEntradas/{id}")
	public ResponseEntity<Entrada> actualizarNumeroEntradas(@PathVariable Long id, @RequestBody Entrada entrada) {
		List<Entrada> lista = servicio.obtenerEntradas();
		for (Entrada ent : lista) {
			if(ent.getId() == id) {
				ent = servicio.actualizarNumeroEntradas(id, entrada);
				return ResponseEntity.ok(ent);
			}
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{nombreComprador}")
	public ResponseEntity<Integer> eliminarEntradasPorComprador(@PathVariable String nombreComprador) {
		Integer numEntrada = servicio.eliminarEntradasPorComprador(nombreComprador);
		return ResponseEntity.ok(numEntrada);
	}
	
	
	
	
	
	
	
	
	
	
	
}
