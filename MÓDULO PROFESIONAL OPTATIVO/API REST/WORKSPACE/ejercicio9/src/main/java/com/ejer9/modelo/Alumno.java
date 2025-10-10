package com.ejer9.modelo;

public class Alumno {
	
	private String nombre;
	private int id;
	private String email;
	private int edad;
	private String curso;
	
	
	public Alumno(String nombre, int id, String email, int edad, String curso) {
		super();
		this.nombre = nombre;
		this.id = id;
		this.email = email;
		this.edad = edad;
		this.curso = curso;
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
	
	

}
