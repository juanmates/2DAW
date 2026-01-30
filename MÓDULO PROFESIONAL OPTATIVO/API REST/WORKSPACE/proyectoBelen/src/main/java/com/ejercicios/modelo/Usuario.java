package com.ejercicios.modelo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
	private String email;
	
	@Column(nullable = false)
	private String contrasenya;
	
	@Column
	private String nombre;

	@Column
	private String rol;
	
	@OneToMany(mappedBy = "usuario_resenyas")
	private List<Vehiculo> resenyas;
	
	@OneToMany(mappedBy = "usuario_reservas")
	private List<Vehiculo> reservas;

}
