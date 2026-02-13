package com.ejercicios.modelo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "autoescuelas")
public class Autoescuela {
	
	// Atributos
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nombre;
	
	@Column(unique = true)
	private String cif;
	
	@OneToOne
	@JoinColumn(name = "id_direccion")
	@JsonIgnoreProperties("autoescuela")
	private Direccion direccion;
	
	@OneToMany(mappedBy = "autoescuela_vehiculos")
	@JsonIgnoreProperties("autoescuela_vehiculos")
	private List<Vehiculo> vehiculos;
	
	@OneToMany(mappedBy = "autoescuela_resenyas")
	@JsonIgnoreProperties("autoescuela_resenyas")
	private List<Resenya> resenyas;
	
	@OneToMany(mappedBy = "autoescuela_tarifas")
	@JsonIgnoreProperties("autoescuela_tarifas")
	private List<Tarifa> tarifas;

	public Autoescuela(Long id, String nombre, String cif, Direccion direccion, List<Vehiculo> vehiculos,
			List<Resenya> resenyas, List<Tarifa> tarifas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.cif = cif;
		this.direccion = direccion;
		this.vehiculos = vehiculos;
		this.resenyas = resenyas;
		this.tarifas = tarifas;
	}

	public Autoescuela() {
		super();
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

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public List<Vehiculo> getVehiculos() {
		return vehiculos;
	}

	public void setVehiculos(List<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}

	public List<Resenya> getResenyas() {
		return resenyas;
	}

	public void setResenyas(List<Resenya> resenyas) {
		this.resenyas = resenyas;
	}

	public List<Tarifa> getTarifas() {
		return tarifas;
	}

	public void setTarifas(List<Tarifa> tarifas) {
		this.tarifas = tarifas;
	}

	@Override
	public String toString() {
		return "Autoescuela [id=" + id + ", nombre=" + nombre + ", cif=" + cif + ", direccion=" + direccion
				+ ", vehiculos=" + vehiculos + ", resenyas=" + resenyas + ", tarifas=" + tarifas + "]";
	}
	
	
	

}
