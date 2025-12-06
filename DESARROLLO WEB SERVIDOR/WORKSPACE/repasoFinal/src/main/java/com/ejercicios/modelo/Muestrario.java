package com.ejercicios.modelo;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "muestrarios")
public class Muestrario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="nombre")
	private String nombre;
	
	@OneToMany(mappedBy = "muestrario", cascade = CascadeType.ALL)
	private List<Receta> recetas;
	
	public Muestrario() {
		super();
	}
	
	public Muestrario(Long id, String nombre, List<Receta> recetas) {
		this.id = id;
		this.nombre = nombre;
		this.recetas = recetas;
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

	public List<Receta> getRecetas() {
		return recetas;
	}

	public void setRecetas(List<Receta> recetas) {
		this.recetas = recetas;
	}

	@Override
	public String toString() {
		return "Muestrario [id=" + id + ", nombre=" + nombre + ", recetas=" + recetas + "]";
	}
	
	

}
