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

}
