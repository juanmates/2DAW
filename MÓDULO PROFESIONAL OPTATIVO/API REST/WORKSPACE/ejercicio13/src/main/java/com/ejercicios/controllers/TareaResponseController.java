package com.ejercicios.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejercicios.modelo.Tarea;


@RestController
@RequestMapping("/tareas")
public class TareaResponseController {
	
	private List<Tarea> tareas = new ArrayList<>();
	
	private Tarea t1 = new Tarea(1, "Programacion", "Hacer los deberes", LocalDate.of(2020, 5, 12), "PENDIENTE");
	private Tarea t2 = new Tarea(2, "Servidor", "Estudiar para el examen", LocalDate.of(2024, 10, 10), "EN_PROCESO");
	private Tarea t3 = new Tarea(3, "Ingles", "Hacer la ficha", LocalDate.of(2025, 8, 8), "PENDIENTE");
	private Tarea t4 = new Tarea(4, "Diseño", "Proyecto Intermodular", LocalDate.of(2000, 2, 22), "COMPLETA");
	
	public TareaResponseController() {
		
		tareas.add(t1);
		tareas.add(t2);
		tareas.add(t3);
		tareas.add(t4);
		
	}
	
	@GetMapping("/tareas/estado/{estado}")
	public ResponseEntity<List<Tarea>> obtenerTareasEstado(@PathVariable String estado) {
		
		List<Tarea> res = new ArrayList<>();
		
		for(Tarea tarea: tareas) {
			if(tarea.getEstado().equalsIgnoreCase(estado)) {
				res.add(tarea);
			}
		}
		return ResponseEntity.ok(res);
	}
	
	@GetMapping("/proximas/{dias}")
	public ResponseEntity<List<Tarea>> getTareasProximosDias(@PathVariable Integer dias){
		
		LocalDate fecha = LocalDate.now().plusDays(dias);
		
		List<Tarea> res = new ArrayList<>();
		
		for(Tarea tarea: tareas) {
			if(tarea.getFechaVencimiento().isBefore(fecha)) {
				res.add(tarea);
			}
		}
		return ResponseEntity.ok(res);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
