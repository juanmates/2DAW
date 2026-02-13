package com.ejercicios.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "resenyas")
public class Resenya {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_resenya;
	
	@Column(nullable = false)
	private Double puntuacion;
	
	@Column
	private String comentario;
	
	@ManyToOne
	@JoinColumn(name = "id_autoescuela")
	@JsonIgnoreProperties("resenyas")
	private Autoescuela autoescuela_resenyas;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	@JsonIgnoreProperties("resenyas")
	private Usuario usuario_resenyas;

	public Resenya(Long id_resenya, Double puntuacion, String comentario, Autoescuela autoescuela_reservas,
			Usuario usuario_resenyas) {
		super();
		this.id_resenya = id_resenya;
		this.puntuacion = puntuacion;
		this.comentario = comentario;
		this.autoescuela_resenyas = autoescuela_reservas;
		this.usuario_resenyas = usuario_resenyas;
	}

	public Resenya() {
		super();
	}

	public Long getId_resenya() {
		return id_resenya;
	}

	public void setId_resenya(Long id_resenya) {
		this.id_resenya = id_resenya;
	}

	public Double getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(Double puntuacion) {
		this.puntuacion = puntuacion;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Autoescuela getAutoescuela_resenyas() {
		return autoescuela_resenyas;
	}

	public void setAutoescuela_resenyas(Autoescuela autoescuela_resenyas) {
		this.autoescuela_resenyas = autoescuela_resenyas;
	}

	public Usuario getUsuario_resenyas() {
		return usuario_resenyas;
	}

	public void setUsuario_resenyas(Usuario usuario_resenyas) {
		this.usuario_resenyas = usuario_resenyas;
	}

	@Override
	public String toString() {
		return "Resenya [id_resenya=" + id_resenya + ", puntuacion=" + puntuacion + ", comentario=" + comentario
				+  "]";
	}
	
	

}
