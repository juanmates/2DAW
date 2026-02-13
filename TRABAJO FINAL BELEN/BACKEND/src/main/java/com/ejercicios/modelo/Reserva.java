package com.ejercicios.modelo;

import java.time.LocalDate;

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
@Table(name = "reservas")
public class Reserva {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_reserva;
	
	@Column
	private LocalDate fecha_reserva;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	@JsonIgnoreProperties("reservas")
	private Usuario usuario_reservas;

	public Reserva(Long id_reserva, LocalDate fecha_reserva, Usuario usuario_reservas) {
		super();
		this.id_reserva = id_reserva;
		this.fecha_reserva = fecha_reserva;
		this.usuario_reservas = usuario_reservas;
	}

	public Reserva() {
		super();
	}

	public Long getId_reserva() {
		return id_reserva;
	}

	public void setId_reserva(Long id_reserva) {
		this.id_reserva = id_reserva;
	}

	public LocalDate getFecha_reserva() {
		return fecha_reserva;
	}

	public void setFecha_reserva(LocalDate fecha_reserva) {
		this.fecha_reserva = fecha_reserva;
	}

	public Usuario getUsuario_reservas() {
		return usuario_reservas;
	}

	public void setUsuario_reservas(Usuario usuario_reservas) {
		this.usuario_reservas = usuario_reservas;
	}

	@Override
	public String toString() {
		return "Reserva [id_reserva=" + id_reserva + ", fecha_reserva=" + fecha_reserva + "]";
	}
	
}
