package com.ejercicios.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "direcciones")
public class Direccion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_direccion;
	
	@Column(nullable = false)
	private String calle;
	
	@Column(nullable = false)
	private String codigoPostal;
	
	@Column(nullable = false)
	private String ciudad;
	
	@Column(nullable = false)
	private String provincia;
	
	@Column(nullable = false)
	private String piso_puerta;
	
	@Column(nullable = false)
	private String pais;
	
	@OneToOne(mappedBy = "direccion")
	@JsonIgnoreProperties("direccion")
	private Autoescuela autoescuela;

	public Direccion(Long id_direccion, String calle, String codigoPostal, String ciudad, String provincia,
			String piso_puerta, String pais, Autoescuela autoescuela) {
		super();
		this.id_direccion = id_direccion;
		this.calle = calle;
		this.codigoPostal = codigoPostal;
		this.ciudad = ciudad;
		this.provincia = provincia;
		this.piso_puerta = piso_puerta;
		this.pais = pais;
		this.autoescuela = autoescuela;
	}

	public Direccion() {
		super();
	}

	public Long getId_direccion() {
		return id_direccion;
	}

	public void setId_direccion(Long id_direccion) {
		this.id_direccion = id_direccion;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getPiso_puerta() {
		return piso_puerta;
	}

	public void setPiso_puerta(String piso_puerta) {
		this.piso_puerta = piso_puerta;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Autoescuela getAutoescuela() {
		return autoescuela;
	}

	public void setAutoescuela(Autoescuela autoescuela) {
		this.autoescuela = autoescuela;
	}

	@Override
	public String toString() {
		return "Direccion [id_direccion=" + id_direccion + ", calle=" + calle + ", codigoPostal=" + codigoPostal
				+ ", ciudad=" + ciudad + ", provincia=" + provincia + ", piso_puerta=" + piso_puerta + ", pais=" + pais
				+ "]";
	}
	
	

}
