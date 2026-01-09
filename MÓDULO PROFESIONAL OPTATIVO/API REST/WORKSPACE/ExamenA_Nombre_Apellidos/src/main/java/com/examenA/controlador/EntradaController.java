package com.examenA.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
}
