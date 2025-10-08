package com.ejercicios.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="vehiculo")
public class Vehiculo {
	
	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="marca")
	private String marca;
	@Column(name="modelo")
	private String modelo;
	@Column(name="anyo")
	private int anyo;
	@Column(name="matricula")
	private String matricula;
	@Column(name="estado")
	private String estado;
	@Column(name="kilometraje")
	private double kilometraje;

	
	// Constructores
	public Vehiculo(String marca, String modelo, int anyo, String matricula, String estado,
			double kilometraje) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.anyo = anyo;
		this.matricula = matricula;
		this.estado = estado;
		this.kilometraje = kilometraje;
	}
	public Vehiculo() {
		super();
	}
	
	
	// Métodos getters and setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getAnyo() {
		return anyo;
	}
	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public double getKilometraje() {
		return kilometraje;
	}
	public void setKilometraje(double kilometraje) {
		this.kilometraje = kilometraje;
	}
	
	
	// ToString
	@Override
	public String toString() {
		return "Vehiculo [id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", anyo=" + anyo + ", matricula="
				+ matricula + ", estado=" + estado + ", kilometraje=" + kilometraje + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
