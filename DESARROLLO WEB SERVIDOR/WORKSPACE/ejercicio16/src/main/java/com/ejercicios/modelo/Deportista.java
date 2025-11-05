package com.ejercicios.modelo;



import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "deportista")
public class Deportista {
	
	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="nombre")
	private String nombre;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "deportista_deporte", 
		joinColumns = {@JoinColumn(name = "id_deportista") },
		inverseJoinColumns = {@JoinColumn(name = "id_deporte") })
	private Set<Deporte> deportes;

	public Deportista(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public Deportista() {
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

	public Set<Deporte> getDeportes() {
		return deportes;
	}

	public void setDeportes(Set<Deporte> deportes) {
		this.deportes = deportes;
	}

	@Override
	public String toString() {
		return "Deportista [id=" + id + ", nombre=" + nombre + "]";
	}

}
