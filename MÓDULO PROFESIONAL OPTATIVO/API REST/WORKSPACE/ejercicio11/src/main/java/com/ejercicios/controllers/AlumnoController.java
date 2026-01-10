package com.ejercicios.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejercicios.modelo.Alumno;


@RestController
@RequestMapping("/alumnos")
public class AlumnoController {
	
private List<Alumno> alumnos = new ArrayList<Alumno>();
	
	private Alumno a1 = new Alumno("Pepito", 1, "pepito@gmail.com", 16, "DAW");
	private Alumno a2 = new Alumno("Pepite", 2, "pepite@gmail.com", 17, "DAM");
	private Alumno a3 = new Alumno("Pepita", 3, "pepita@gmail.com", 18, "DAWN");
	private Alumno a4 = new Alumno("Pepiti", 4, "pepiti@gmail.com", 19, "DOWN");
	
	public AlumnoController() {
		
		alumnos.add(a1);
		alumnos.add(a2);
		alumnos.add(a3);
		alumnos.add(a4);

	}
	
	@GetMapping
	public List<Alumno> getAlumnos(){
		return alumnos;
	}
	
	@GetMapping("/{email}")
	public Alumno getCliente(@PathVariable String email) {
		
		for (Alumno alumno : alumnos) {
			if(alumno.getEmail().equalsIgnoreCase(email)) {
				return alumno;
			}
		}
		return null;
	}
	
	@PostMapping
	public Alumno postAlumno(@RequestBody Alumno alumno) {
		alumnos.add(alumno);
		return alumno;
	}
	
	@PutMapping
	public Alumno putCliente(@RequestBody Alumno modif) {
		for (Alumno alumno : alumnos) {
			if (alumno.getId()==(modif.getId())) {
				alumno.setNombre(modif.getNombre());
				alumno.setEmail(modif.getEmail());
				alumno.setEdad(modif.getEdad());
				alumno.setCurso(modif.getCurso());
				return alumno;
			}
		}
		return null;
	}
	
	@PatchMapping
	public Alumno pathCliente(@RequestBody Alumno modif) {
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
				return alumno;
			}

		}
		return null;
	}
	
	@DeleteMapping("/{id}")
	public Alumno deleteCliente(@PathVariable int id) {
		Iterator<Alumno> iterador = alumnos.iterator();
		while (iterador.hasNext()) {
			Alumno alumno = iterador.next();
			if (alumno.getId() == id) {
				iterador.remove();
				return alumno;
			}
		}
		return null;
	}

}
