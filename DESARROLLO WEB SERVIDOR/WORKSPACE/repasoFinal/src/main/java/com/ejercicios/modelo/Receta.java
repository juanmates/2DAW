package com.ejercicios.modelo;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "recetas")
public class Receta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="puntuacion")
	private Integer puntuacion;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "ingrediente_receta",
			joinColumns = {@JoinColumn(name = "id_ingrediente")} , 
			inverseJoinColumns = {@JoinColumn(name = "id_receta")})
	private List<Ingrediente> ingredientes;
	
	@ManyToOne
	@JoinColumn(name = "id_muestrario")
	private Muestrario muestrario;
	
	
	public Receta() {
		super();
	}
	
	public Receta(Long id, String nombre, Integer puntuacion) {
		super();
		this.id = id;
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

	public List<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(List<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}

	@Override
	public String toString() {
		return "Receta [id=" + id + ", nombre=" + nombre + ", puntuacion=" + puntuacion + ", ingredientes="
				+ ingredientes + "]";
	}
	
	
}
