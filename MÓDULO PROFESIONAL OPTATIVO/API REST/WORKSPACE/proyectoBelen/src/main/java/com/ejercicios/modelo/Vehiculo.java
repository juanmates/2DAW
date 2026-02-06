package com.ejercicios.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "vehiculos")
public class Vehiculo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_vehiculo;
	
	@Column(unique = true)
	private String matricula;
	
	@Column
	private String marca_modelo;
	
	@Column
	private String tipo_permiso;
	
	@ManyToOne
	@JoinColumn(name = "id_autoescuela")
	private Autoescuela autoescuela_vehiculos;

	public Vehiculo(Long id_vehiculo, String matricula, String marca_modelo, String tipo_permiso,
			Autoescuela autoescuela_vehiculos) {
		super();
		this.id_vehiculo = id_vehiculo;
		this.matricula = matricula;
		this.marca_modelo = marca_modelo;
		this.tipo_permiso = tipo_permiso;
		this.autoescuela_vehiculos = autoescuela_vehiculos;
	}

	public Vehiculo() {
		super();
	}

	public Long getId_vehiculo() {
		return id_vehiculo;
	}

	public void setId_vehiculo(Long id_vehiculo) {
		this.id_vehiculo = id_vehiculo;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMarca_modelo() {
		return marca_modelo;
	}

	public void setMarca_modelo(String marca_modelo) {
		this.marca_modelo = marca_modelo;
	}

	public String getTipo_permiso() {
		return tipo_permiso;
	}

	public void setTipo_permiso(String tipo_permiso) {
		this.tipo_permiso = tipo_permiso;
	}

	public Autoescuela getAutoescuela_vehiculos() {
		return autoescuela_vehiculos;
	}

	public void setAutoescuela_vehiculos(Autoescuela autoescuela_vehiculos) {
		this.autoescuela_vehiculos = autoescuela_vehiculos;
	}

	@Override
	public String toString() {
		return "Vehiculo [id_vehiculo=" + id_vehiculo + ", matricula=" + matricula + ", marca_modelo=" + marca_modelo
				+ ", tipo_permiso=" + tipo_permiso + ", autoescuela_vehiculos=" + autoescuela_vehiculos + "]";
	}
	
}
