package com.ejercicios.modelos;

import java.util.List;

public class Libro {
	
	private Integer id;
	private String titulo;
	private String autor;
	private String editorial;
	private String isbn;
	private Integer anyoPublicacion;
	private List<String> generos;
	
	public Libro() {
	}
	
	public Libro(Integer id, String titulo, String autor, String editorial, String isbn, Integer anyoPublicacion, List<String> generos) {
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		this.isbn = isbn;
		this.anyoPublicacion = anyoPublicacion;
		this.generos = generos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Integer getAnyoPublicacion() {
		return anyoPublicacion;
	}

	public void setAnyoPublicacion(Integer anyoPublicacion) {
		this.anyoPublicacion = anyoPublicacion;
	}

	public List<String> getGeneros() {
		return generos;
	}

	public void setGeneros(List<String> generos) {
		this.generos = generos;
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", editorial=" + editorial + ", isbn="
				+ isbn + ", añoPublicacion=" + anyoPublicacion + ", generos=" + generos + "]";
	}
	

}
