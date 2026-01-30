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

}
