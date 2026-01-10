package com.ej16.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Deportista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String nombre;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(
        name = "deportista_deporte",
        joinColumns = @JoinColumn(name = "deportista_id"),
        inverseJoinColumns = @JoinColumn(name = "deporte_id")
    )
    /*
     *  Ejercicio 17: 
     @ManyToMany(mappedBy = "deportistas", fetch = FetchType.EAGER,cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Deporte> deportes = new HashSet<>();
     */
    private Set<Deporte> deportes = new HashSet<>();

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

    public Set<Deporte> getDeportes() {
        return deportes;
    }

    public void setDeportes(Set<Deporte> deportes) {
        this.deportes = deportes;
    }

    public void agregarDeporte(Deporte deporte) {
        this.deportes.add(deporte);
        //deporte.getDeportistas().add(this);  //Ejercicio 17
    }

    public void eliminarDeporte(Deporte deporte) {
        this.deportes.remove(deporte);
        //deporte.getDeportistas().remove(this);  //Ejercicio 17
    }

    @Override
    public String toString() {
        return "Deportista{id=" + id + ", nombre='" + nombre + "', deportes=" + deportes + "}";
    }
}
