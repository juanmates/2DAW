package com.ejercicios.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="empleado")
public class Empleado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="puesto")
	private String puesto;
	
	@Column(name="email")
	private String email;
	
	@Column(name = "oficina_id ")
	private Oficina oficina_id;
	
	public Empleado() {
		
	}
	
	public Empleado(String nombre, String puesto, String email, Oficina oficina_id) {
		this.nombre = nombre;
		this.puesto = puesto;
		this.email = email;
		this.oficina_id = oficina_id;
	}

	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", puesto=" + puesto + ", email=" + email + ", oficina_id="
				+ oficina_id + "]";
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

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Oficina getOficina_id() {
		return oficina_id;
	}

	public void setOficina_id(Oficina oficina_id) {
		this.oficina_id = oficina_id;
	}
	
	

}
