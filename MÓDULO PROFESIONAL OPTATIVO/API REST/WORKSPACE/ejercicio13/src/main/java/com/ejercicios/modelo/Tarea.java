package com.ejercicios.modelo;

import java.time.LocalDate;

public class Tarea {
	
	private int id;
	private String titulo;
	private String descripcion;
	private LocalDate fechaVencimiento;
	private String Estado;
	
	public Tarea() {
		super();
	}

	public Tarea(int id, String titulo, String descripcion, LocalDate fechaVencimiento, String estado) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.fechaVencimiento = fechaVencimiento;
		Estado = estado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public LocalDate getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(LocalDate fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}

	@Override
	public String toString() {
		return "Tarea [id=" + id + ", titulo=" + titulo + ", descripcion=" + descripcion + ", fechaVencimiento="
				+ fechaVencimiento + ", Estado=" + Estado + "]";
	}
	
	

}
