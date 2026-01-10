package com.ejercicios.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ejercicios.modelo.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

    List<Animal> findByEspecie(String especie);

    // Devuelve especie, nombre y habitat por edad
    @Query("SELECT a FROM Animal a WHERE a.edad = :edad")
    List<Animal> findByEdad(@Param("edad") int edad);
    //List<Animal> findByEdad(int edad);

    // Animales que entraron en los últimos x años
    @Query("SELECT a FROM Animal a WHERE a.fechaIngreso >= :fechaLimite")
    List<Animal> findAnimalesDesdeFecha(@Param("fechaLimite") LocalDate fechaLimite);
    //List<Animal> findByFechaIngresoAfter(LocalDate fecha);    

    List<Animal> findByFechaIngresoBefore(LocalDate fecha);

    List<Animal> findByFechaIngresoAfter(LocalDate fecha);

    List<Animal> findByFechaIngresoBetween(LocalDate inicio, LocalDate fin);

    List<Animal> findAllByOrderByFechaIngresoAsc();

    List<Animal> findAllByOrderByFechaIngresoDesc();

    @Query("SELECT COUNT(a) FROM Animal a WHERE YEAR(a.fechaIngreso) = :anio")
    Long contarAnimalesIngresadosEnAnio(@Param("anio") int anio);
    
    //int countByFechaIngresoBetween(LocalDate inicio, LocalDate fin);
}