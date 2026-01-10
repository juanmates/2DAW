package com.ejercicios.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "hotel")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nombre;

    @Column(nullable = false)
    private String direccion;

    @Column(nullable = false)
    private int estrellas;

    @Column(nullable = false)
    private String telefono;

    @Column(name = "pagina_web")
    private String paginaWeb;

    public Hotel() {}

    public Hotel(String nombre, String direccion, int estrellas, String telefono, String paginaWeb) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.estrellas = estrellas;
        this.telefono = telefono;
        this.paginaWeb = paginaWeb;
    }

   
    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", estrellas=" + estrellas +
                ", telefono='" + telefono + '\'' +
                ", paginaWeb='" + paginaWeb + '\'' +
                '}';
    }
}