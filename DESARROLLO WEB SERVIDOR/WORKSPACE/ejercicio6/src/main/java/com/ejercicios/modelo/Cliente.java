package com.ejercicios.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="cliente")
public class Cliente {
	
	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="nombre")
	private String nombre;
	@OneToOne
	@JoinColumn(name = "direccion_id")
	private Direccion direccion;

	// Contructores
	public Cliente( String nombre, Direccion direccion) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
	}
	
	// Getters and Setters
	public Cliente() {
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

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	// ToString

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + "]";
	}
	

}
