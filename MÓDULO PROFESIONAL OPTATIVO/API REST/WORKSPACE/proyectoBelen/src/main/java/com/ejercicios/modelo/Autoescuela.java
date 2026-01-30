package com.ejercicios.modelo;

import java.util.List;

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
	private Direccion direccion;
	
	@OneToMany(mappedBy = "autoescuela_vehiculos")
	private List<Vehiculo> vehiculos;
	
	@OneToMany(mappedBy = "autoescuela_reservas")
	private List<Vehiculo> resenyas;
	

}
