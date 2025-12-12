package com.examenA.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.examenA.modelo.Entrada;
import com.examenA.servicio.EntradaServicio;



@Controller
@CrossOrigin(origins="*")
@RequestMapping("/api/entradas")
public class EntradaController {
	
	
	@Autowired
	EntradaServicio servicio;
	
	
	@PutMapping()
	private Entrada postComprar(Entrada entrada) {
		return servicio.crearEntrada(entrada);
	}

}
