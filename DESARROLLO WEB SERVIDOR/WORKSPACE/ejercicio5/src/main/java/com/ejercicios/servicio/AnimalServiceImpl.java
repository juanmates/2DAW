package com.ejercicios.servicio;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejercicios.modelo.Animal;
import com.ejercicios.repository.AnimalRepository;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class AnimalServiceImpl implements AnimalService {

    @Autowired
	AnimalRepository repo;
  
    @Override
    public Animal crearAnimal(Animal animal) {
        return repo.save(animal);
    }

    @Override
    public Optional<Animal> getAnimalPorId(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<Animal> getTodosAnimales() {
        return repo.findAll();
    }

    @Override
    public Animal actualizarAnimal(Long id, Animal animal) {
        Optional<Animal> op = repo.findById(id);
        if (op.isPresent()) {
            Animal existente = op.get();
            existente.setNombre(animal.getNombre());
            existente.setEspecie(animal.getEspecie());
            existente.setEdad(animal.getEdad());
            existente.setHabitat(animal.getHabitat());
            existente.setFechaIngreso(animal.getFechaIngreso());
            return repo.save(existente);
        }
        return null;
    }

    @Override
    public void eliminarAnimal(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<Animal> animalesPorEspecie(String especie) {
        return repo.findByEspecie(especie);
    }

    @Override
    public List<Animal> animalesPorEdad(int edad) {
        return repo.findByEdad(edad);
    }

    @Override
    public List<Animal> animalesDesdeAnyo(int años) {
        LocalDate limite = LocalDate.now().minusYears(años);
        return repo.findAnimalesDesdeFecha(limite);
    }

    @Override
    public List<Animal> animalesAntesDeFecha(LocalDate fecha) {
        return repo.findByFechaIngresoBefore(fecha);
    }

    @Override
    public List<Animal> animalesDespuesDeFecha(LocalDate fecha) {
        return repo.findByFechaIngresoAfter(fecha);
    }

    @Override
    public List<Animal> animalesEntreFechas(LocalDate inicio, LocalDate fin) {
        return repo.findByFechaIngresoBetween(inicio, fin);
    }

    @Override
    public List<Animal> animalesOrdenadosPorFechaIngreso(boolean ascendente) {
        if (ascendente) {
            return repo.findAllByOrderByFechaIngresoAsc();
        } else {
            return repo.findAllByOrderByFechaIngresoDesc();
        }
    }

    @Override
    public Long contarAnimalesIngresadosEnAnyo(int anio) {
        return repo.contarAnimalesIngresadosEnAnio(anio);
        
        /* Otra forma:
         
         	LocalDate inicio = LocalDate.of(anyo, 1, 1);
			LocalDate fin = LocalDate.of(anyo, 12, 31);
			int count = animalRepository.countByFechaIngresoBetween(inicio, fin);
         
         */
    }
}