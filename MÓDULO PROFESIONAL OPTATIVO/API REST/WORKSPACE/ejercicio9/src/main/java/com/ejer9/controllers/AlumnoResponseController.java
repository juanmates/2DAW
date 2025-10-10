package com.ejer9.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejer9.modelo.Alumno;

@RestController
@RequestMapping("/alumnos")
public class AlumnoResponseController {
	
private List<Alumno> alumnos = new ArrayList<Alumno>();
	
	private Alumno a1 = new Alumno("Pepito", 1, "pepito@gmail.com", 16, "DAW");
	private Alumno a2 = new Alumno("Pepite", 2, "pepite@gmail.com", 17, "DAM");
	private Alumno a3 = new Alumno("Pepita", 3, "pepita@gmail.com", 18, "DAWN");
	private Alumno a4 = new Alumno("Pepiti", 4, "pepiti@gmail.com", 19, "DOWN");
	
	public AlumnoResponseController() {
		
		alumnos.add(a1);
		alumnos.add(a2);
		alumnos.add(a3);
		alumnos.add(a4);

	}
	
	@GetMapping
	public ResponseEntity<List<Alumno>> getAlumnos(){
		return ResponseEntity.ok(alumnos);
	}
	
	@GetMapping("/{email}")
	public ResponseEntity<Alumno> getCliente(@PathVariable String email) {
		
		for (Alumno alumno : alumnos) {
			if(alumno.getEmail().equalsIgnoreCase(email)) {
				return ResponseEntity.ok(alumno);
			}
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Alumno> postAlumno(@RequestBody Alumno alumno) {
		alumnos.add(alumno);
		return ResponseEntity.noContent().build();
		//return ResponseEntity.ok(alumno) tb se puede poner este
	}
	
	@PutMapping
	public ResponseEntity<Alumno> putCliente(@RequestBody Alumno modif) {
		for (Alumno alumno : alumnos) {
			if (alumno.getId()==(modif.getId())) {
				alumno.setNombre(modif.getNombre());
				alumno.setEmail(modif.getEmail());
				alumno.setEdad(modif.getEdad());
				alumno.setCurso(modif.getCurso());
				return ResponseEntity.ok(alumno);
			}
		}
		return ResponseEntity.notFound().build();
	}
	
	@PatchMapping
	public ResponseEntity<Alumno> pathCliente(@RequestBody Alumno modif) {
		for (Alumno alumno : alumnos) {
			if (alumno.getId() == modif.getId()) {
				if (modif.getNombre() != null) {
					System.out.println("nombre");
					alumno.setNombre(modif.getNombre());
				}
				if (modif.getEmail() != null) {
					System.out.println("email");
					alumno.setEmail(modif.getEmail());
				}
				if (modif.getEdad() == 0) {
					System.out.println("edad");
					alumno.setEdad(modif.getEdad());
				}
				if (modif.getCurso() != null) {
					System.out.println("curso");
					alumno.setCurso(modif.getCurso());
				}
				return ResponseEntity.ok(alumno);
			}

		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Alumno> deleteCliente(@PathVariable int id) {
		Iterator<Alumno> iterador = alumnos.iterator();
		while (iterador.hasNext()) {
			Alumno alumno = iterador.next();
			if (alumno.getId() == id) {
				iterador.remove();
				return ResponseEntity.ok(alumno);
			}
		}
		return ResponseEntity.noContent().build();
	}


}
