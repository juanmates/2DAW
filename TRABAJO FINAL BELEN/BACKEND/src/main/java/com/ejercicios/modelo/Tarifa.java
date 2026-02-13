package com.ejercicios.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tarifas")
public class Tarifa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_tarifa;
	
	@Column(nullable = false)
	private String tipo_permiso;
	
	@Column
	private Double precio_matricula;
	
	@Column
	private Double precio_clase;
	
	@ManyToOne
	@JoinColumn(name = "id_autoescuela")
	@JsonIgnoreProperties("tarifas")
	private Autoescuela autoescuela_tarifas;

	public Tarifa(Long id_tarifa, String tipo_permiso, Double precio_matricula, Double precio_clase,
			Autoescuela autoescuela_tarifas) {
		super();
		this.id_tarifa = id_tarifa;
		this.tipo_permiso = tipo_permiso;
		this.precio_matricula = precio_matricula;
		this.precio_clase = precio_clase;
		this.autoescuela_tarifas = autoescuela_tarifas;
	}

	public Tarifa() {
		super();
	}

	public Long getId_tarifa() {
		return id_tarifa;
	}

	public void setId_tarifa(Long id_tarifa) {
		this.id_tarifa = id_tarifa;
	}

	public String getTipo_permiso() {
		return tipo_permiso;
	}

	public void setTipo_permiso(String tipo_permiso) {
		this.tipo_permiso = tipo_permiso;
	}

	public Double getPrecio_matricula() {
		return precio_matricula;
	}

	public void setPrecio_matricula(Double precio_matricula) {
		this.precio_matricula = precio_matricula;
	}

	public Double getPrecio_clase() {
		return precio_clase;
	}

	public void setPrecio_clase(Double precio_clase) {
		this.precio_clase = precio_clase;
	}

	public Autoescuela getAutoescuela_tarifas() {
		return autoescuela_tarifas;
	}

	public void setAutoescuela_tarifas(Autoescuela autoescuela_tarifas) {
		this.autoescuela_tarifas = autoescuela_tarifas;
	}

	@Override
	public String toString() {
		return "Tarifa [id_tarifa=" + id_tarifa + ", tipo_permiso=" + tipo_permiso + ", precio_matricula="
				+ precio_matricula + ", precio_clase=" + precio_clase + "]";
	}
	
	
	
}
