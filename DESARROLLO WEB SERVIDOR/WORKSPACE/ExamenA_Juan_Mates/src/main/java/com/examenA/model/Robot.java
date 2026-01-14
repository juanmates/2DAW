package com.examenA.model;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "robot")
public class Robot {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String modelo;
	@Column
	private String categoria;
	@Column
	private Integer anioFabricacion;
	@Column
	private Double nivelBateria;
	@Column
	private Boolean operativo;
	@Column
	private Double pesoKg;
	
	@OneToMany(mappedBy = "robot", cascade = CascadeType.ALL)
	private List<Sensor> sensores = new ArrayList<>();
	
	public Robot() {
		super();
	}

	public Robot(String modelo, String categoria, Integer anioFabricacion, Double nivelBateria,
			Boolean operativo, Double pesoKg) {
		super();
		this.modelo = modelo;
		this.categoria = categoria;
		this.anioFabricacion = anioFabricacion;
		this.nivelBateria = nivelBateria;
		this.operativo = operativo;
		this.pesoKg = pesoKg;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Integer getAnioFabricacion() {
		return anioFabricacion;
	}

	public void setAnioFabricacion(Integer anioFabricacion) {
		this.anioFabricacion = anioFabricacion;
	}

	public Double getNivelBateria() {
		return nivelBateria;
	}

	public void setNivelBateria(Double nivelBateria) {
		this.nivelBateria = nivelBateria;
	}

	public Boolean getOperativo() {
		return operativo;
	}

	public void setOperativo(Boolean operativo) {
		this.operativo = operativo;
	}

	public Double getPesoKg() {
		return pesoKg;
	}

	public void setPesoKg(Double pesoKg) {
		this.pesoKg = pesoKg;
	}

	public List<Sensor> getSensores() {
		return sensores;
	}

	public void setSensores(List<Sensor> sensores) {
		this.sensores = sensores;
	}

	@Override
	public String toString() {
		return "Robot [id=" + id + ", modelo=" + modelo + ", categoria=" + categoria + ", anioFabricacion="
				+ anioFabricacion + ", nivelBateria=" + nivelBateria + ", operativo=" + operativo + ", pesoKg=" + pesoKg
				+ ", sensores=" + sensores + "]";
	}
	
}
