package com.examenA.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "sensor")
public class Sensor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String tipo;
	@Column
	private Double precisionV;
	@Column
	private String unidadMedida;
	@Column
	private Double rangoMaximo;
	@Column
	private Double consumoEnegia;
	@Column
	private Boolean activo;
	
	@ManyToOne
	@JoinColumn(name = "id_robot")
	private Robot robot;

	public Sensor( String tipo, Double precisionV, String unidadMedida, Double rangoMaximo,
			Double consumoEnegia, Boolean activo) {
		super();
		this.tipo = tipo;
		this.precisionV = precisionV;
		this.unidadMedida = unidadMedida;
		this.rangoMaximo = rangoMaximo;
		this.consumoEnegia = consumoEnegia;
		this.activo = activo;
	}

	public Sensor() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Double getPrecisionV() {
		return precisionV;
	}

	public void setPrecisionV(Double precisionV) {
		this.precisionV = precisionV;
	}

	public String getUnidadMedida() {
		return unidadMedida;
	}

	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}

	public Double getRangoMaximo() {
		return rangoMaximo;
	}

	public void setRangoMaximo(Double rangoMaximo) {
		this.rangoMaximo = rangoMaximo;
	}

	public Double getConsumoEnegia() {
		return consumoEnegia;
	}

	public void setConsumoEnegia(Double consumoEnegia) {
		this.consumoEnegia = consumoEnegia;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public Robot getRobot() {
		return robot;
	}

	public void setRobot(Robot robot) {
		this.robot = robot;
	}

	@Override
	public String toString() {
		return "Sensor [id=" + id + ", tipo=" + tipo + ", precisionV=" + precisionV + ", unidadMedida=" + unidadMedida
				+ ", rangoMaximo=" + rangoMaximo + ", consumoEnegia=" + consumoEnegia + ", activo=" + activo
				+ ", robot=" + robot + "]";
	}

}
