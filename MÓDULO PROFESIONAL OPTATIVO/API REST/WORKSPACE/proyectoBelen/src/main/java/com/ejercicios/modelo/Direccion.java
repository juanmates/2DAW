package com.ejercicios.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "direcciones")
public class Direccion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_direccion;
	
	@Column(nullable = false)
	private String calle;
	
	@Column(nullable = false)
	private String codigoPostal;
	
	@Column(nullable = false)
	private String ciudad;
	
	@Column(nullable = false)
	private String provincia;
	
	@Column(nullable = false)
	private String piso_puerta;
	
	@Column(nullable = false)
	private String pais;
	
	@OneToOne(mappedBy = "direccion")
	private Autoescuela autoescuela;

}
