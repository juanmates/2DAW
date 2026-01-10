package com.ejercicios.modelo;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Ingrediente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nombre;

	private Integer calorias;

	@ManyToMany(mappedBy = "ingredientes")
	private Set<Receta> recetas = new HashSet<>();

// Constructores, getters y setters
	public Ingrediente() {
	}

	public Ingrediente(String nombre, Integer calorias) {
		this.nombre = nombre;
		this.calorias = calorias;
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

	public Integer getCalorias() {
		return calorias;
	}

	public void setCalorias(Integer calorias) {
		this.calorias = calorias;
	}

	public Set<Receta> getRecetas() {
		return recetas;
	}

	public void setRecetas(Set<Receta> recetas) {
		this.recetas = recetas;
	}
}

