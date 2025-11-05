package com.ejercicio14.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Curso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; 
	
	
	private String nombre; 
	
	private String description; 
	
	
	@OneToMany(mappedBy = "curso", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Estudiante> estudiantes;


	public Curso() {
		super();
	}


	public Curso(Integer id, String nombre, String description, List<Estudiante> estudiantes) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.description = description;
		this.estudiantes = estudiantes;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public List<Estudiante> getEstudiantes() {
		return estudiantes;
	}


	public void setEstudiantes(List<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}


	@Override
	public String toString() {
		return "Curso [id=" + id + ", nombre=" + nombre + ", description=" + description + ", estudiantes="
				+ estudiantes + "]";
	} 
	
	
	
	
}
