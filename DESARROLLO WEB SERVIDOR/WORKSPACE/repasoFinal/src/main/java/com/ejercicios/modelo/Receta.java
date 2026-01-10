package com.ejercicios.modelo;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Receta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nombre;

	private Integer puntuacion;

	@ManyToMany
	@JoinTable(name = "receta_ingrediente", joinColumns = @JoinColumn(name = "receta_id"), inverseJoinColumns = @JoinColumn(name = "ingrediente_id"))
	private Set<Ingrediente> ingredientes = new HashSet<>();

	@ManyToOne
	private Muestrario muestrario;

// Constructores, getters y setters
	public Receta() {
	}

	public Receta(String nombre, Integer puntuacion) {
		this.nombre = nombre;
		this.puntuacion = puntuacion;
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

	public Integer getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(Integer puntuacion) {
		this.puntuacion = puntuacion;
	}

	public Set<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(Set<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}

	public Muestrario getMuestrario() {
		return muestrario;
	}

	public void setMuestrario(Muestrario muestrario) {
		this.muestrario = muestrario;
	}
}
