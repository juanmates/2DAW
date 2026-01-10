package com.ejercicios.modelo;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Muestrario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nombre;

	@OneToMany(mappedBy = "muestrario", cascade = CascadeType.ALL)
	private Set<Receta> recetas = new HashSet<>();

	public Muestrario() {
	}

	public Muestrario(String nombre) {
		this.nombre = nombre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Receta> getRecetas() {
		return recetas;
	}

	public void setRecetas(Set<Receta> recetas) {
		this.recetas = recetas;
	}
}
