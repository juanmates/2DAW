package com.ejercicios.modelo;

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
	private Integer puntuacion;
	
	@Column
	private String comentario;
	
	@ManyToOne
	@JoinColumn(name = "id_autoescuela")
	private Autoescuela autoescuela_reservas;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario_resenyas;

	public Resenya(Long id_resenya, Integer puntuacion, String comentario, Autoescuela autoescuela_reservas,
			Usuario usuario_resenyas) {
		super();
		this.id_resenya = id_resenya;
		this.puntuacion = puntuacion;
		this.comentario = comentario;
		this.autoescuela_reservas = autoescuela_reservas;
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

	public Integer getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(Integer puntuacion) {
		this.puntuacion = puntuacion;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Autoescuela getAutoescuela_reservas() {
		return autoescuela_reservas;
	}

	public void setAutoescuela_reservas(Autoescuela autoescuela_reservas) {
		this.autoescuela_reservas = autoescuela_reservas;
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
				+ ", autoescuela_reservas=" + autoescuela_reservas + ", usuario_resenyas=" + usuario_resenyas + "]";
	}
	
	

}
