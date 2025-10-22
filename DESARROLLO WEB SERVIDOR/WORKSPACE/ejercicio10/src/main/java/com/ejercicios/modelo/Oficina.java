package com.ejercicios.modelo;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="empleado")
public class Oficina {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="ubicacion")
	private String ubicacion;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "oficina_id")
	private List<Empleado> empleados;
	
	public Oficina() {
		
	}
	
	public Oficina(String ubicacion, List<Empleado> empleados) {
		this.ubicacion = ubicacion;
		this.empleados = empleados;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public List<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

	@Override
	public String toString() {
		return "Oficina [id=" + id + ", ubicacion=" + ubicacion + ", empleados=" + empleados + "]";
	}
	
	
	
}
