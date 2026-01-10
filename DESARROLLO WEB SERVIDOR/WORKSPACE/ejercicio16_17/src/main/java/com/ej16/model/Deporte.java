package com.ej16.model;

import jakarta.persistence.*;

@Entity
public class Deporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String nombre;
    
    /*Ej 17
     @ManyToMany(mappedBy = "deportes")
    private Set<Deportista> deportistas = new HashSet<>();
     */

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Deporte{id=" + id + ", nombre='" + nombre + "'}";
    }
}
