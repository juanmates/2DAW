package com.ej09.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
public class Perfil {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String bio;
	@Column
	private String estado;

	@OneToOne(mappedBy = "perfil", cascade = CascadeType.ALL, orphanRemoval = true)
	private Usuario usu;

	public Perfil() {
		super();
	}

	public Perfil(String bio, String estado) {
		super();

		this.bio = bio;
		this.estado = estado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Usuario getUsu() {
		return usu;
	}

	public void setUsu(Usuario usu) {
		this.usu = usu;
	}

	@Override
	public String toString() {
		return "Perfil [id=" + id + ", bio=" + bio + ", estado=" + estado + "usurio: " + usu.getNombre() + ": "
				+ usu.getEmail() + "]";
	}

}