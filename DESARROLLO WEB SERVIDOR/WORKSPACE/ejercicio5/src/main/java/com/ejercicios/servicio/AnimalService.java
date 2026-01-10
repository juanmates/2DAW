package com.ejercicios.servicio;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.ejercicios.modelo.Animal;

public interface AnimalService {

    // CRUD básico
    Animal crearAnimal(Animal animal);

    Optional<Animal> getAnimalPorId(Long id);

    List<Animal> getTodosAnimales();

    Animal actualizarAnimal(Long id, Animal animal);

    void eliminarAnimal(Long id);

    // Métodos adicionales
    List<Animal> animalesPorEspecie(String especie);

    List<Animal> animalesPorEdad(int edad);

    List<Animal> animalesDesdeAnyo(int años);

    List<Animal> animalesAntesDeFecha(LocalDate fecha);

    List<Animal> animalesDespuesDeFecha(LocalDate fecha);

    List<Animal> animalesEntreFechas(LocalDate inicio, LocalDate fin);

    List<Animal> animalesOrdenadosPorFechaIngreso(boolean ascendente);

    Long contarAnimalesIngresadosEnAnyo(int anio);
}
