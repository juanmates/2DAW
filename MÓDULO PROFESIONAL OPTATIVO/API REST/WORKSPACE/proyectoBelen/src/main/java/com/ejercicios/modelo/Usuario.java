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

	public Usuario(Long id, String email, String contrasenya, String nombre, String rol, List<Vehiculo> resenyas,
			List<Vehiculo> reservas) {
		super();
		this.id = id;
		this.email = email;
		this.contrasenya = contrasenya;
		this.nombre = nombre;
		this.rol = rol;
		this.resenyas = resenyas;
		this.reservas = reservas;
	}

	public Usuario() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContrasenya() {
		return contrasenya;
	}

	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public List<Vehiculo> getResenyas() {
		return resenyas;
	}

	public void setResenyas(List<Vehiculo> resenyas) {
		this.resenyas = resenyas;
	}

	public List<Vehiculo> getReservas() {
		return reservas;
	}

	public void setReservas(List<Vehiculo> reservas) {
		this.reservas = reservas;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", email=" + email + ", contrasenya=" + contrasenya + ", nombre=" + nombre
				+ ", rol=" + rol + ", resenyas=" + resenyas + ", reservas=" + reservas + "]";
	}
	
	

}
