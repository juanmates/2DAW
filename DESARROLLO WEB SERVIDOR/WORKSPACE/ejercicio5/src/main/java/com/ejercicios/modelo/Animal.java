package com.ejercicios.modelo;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "animales")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String especie;

    @Column(nullable = false)
    private int edad;

    @Column(nullable = false)
    private String habitat;

    @Column(name = "fechaIngreso", nullable = false)
    private LocalDate fechaIngreso;

    // Constructor vacío para JPA
    public Animal() {}

    // Constructor con campos (sin id)
    public Animal(String nombre, String especie, int edad, String habitat, LocalDate fechaIngreso) {
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
        this.habitat = habitat;
        this.fechaIngreso = fechaIngreso;
    }




    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getHabitat() {
		return habitat;
	}

	public void setHabitat(String habitat) {
		this.habitat = habitat;
	}

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	// toString para mostrar resultados
    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", especie='" + especie + '\'' +
                ", edad=" + edad +
                ", habitat='" + habitat + '\'' +
                ", fechaIngreso=" + fechaIngreso +
                '}';
    }
    
    
}