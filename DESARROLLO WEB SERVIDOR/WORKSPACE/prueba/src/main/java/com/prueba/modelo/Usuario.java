package com.prueba.modelo;

public class Usuario {
	
	// Atributos
	
	private Integer id;
	private String nombre;
	private String correo;
	private Integer edad;
	
	// Métodos
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	
	// ToString
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", correo=" + correo + ", edad=" + edad + "]";
	}

}
