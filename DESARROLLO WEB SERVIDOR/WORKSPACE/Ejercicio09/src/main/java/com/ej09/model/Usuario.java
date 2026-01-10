package com.ej09.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;
    
    @Column
    private String email;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "perfil_id")
    private Perfil perfil;
    

	public Usuario() {
		super();
	}

	public Usuario(String nombre, String email, Perfil perfil) {
		super();
	
		this.nombre = nombre;
		this.email = email;
		this.perfil = perfil;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", email=" + email + ", perfil=" + perfil.getEstado() + ": "+ perfil.getBio() + "]";
	}
	
	

    
}
