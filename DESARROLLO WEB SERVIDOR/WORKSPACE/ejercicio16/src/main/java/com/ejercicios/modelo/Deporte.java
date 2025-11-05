package com.ejercicios.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "deporte")
public class Deporte {

	//Atributos
	private int id;
	private String nombre;
	public Deporte(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	public Deporte() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "Deporte [id=" + id + ", nombre=" + nombre + "]";
	}

	
	
	
	
	
	
}
