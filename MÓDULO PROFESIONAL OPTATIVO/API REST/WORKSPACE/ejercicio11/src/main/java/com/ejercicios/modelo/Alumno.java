package com.ejercicios.modelo;

public class Alumno {
	
	private String nombre;
	private int id;
	private String email;
	private int edad;
	private String curso;
	private Direccion direccion;
	
	
	public Alumno(String nombre, int id, String email, int edad, String curso, Direccion direccion) {
		super();
		this.nombre = nombre;
		this.id = id;
		this.email = email;
		this.edad = edad;
		this.curso = curso;
		this.direccion = direccion;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	
	

}
