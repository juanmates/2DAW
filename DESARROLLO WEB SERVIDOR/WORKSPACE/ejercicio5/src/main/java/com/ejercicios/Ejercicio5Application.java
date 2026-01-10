package com.ejercicios;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ejercicios.modelo.Animal;
import com.ejercicios.servicio.AnimalService;

@SpringBootApplication
public class Ejercicio5Application implements CommandLineRunner
{

	@Autowired 
	AnimalService service;
	
	public static void main(String[] args) {
		SpringApplication.run(Ejercicio5Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		service.crearAnimal(new Animal("Simba", "León", 5, "Sabana", LocalDate.of(2020, 3, 15)));
        service.crearAnimal(new Animal("Manny", "Elefante", 10, "Sabana", LocalDate.of(2018, 6, 12)));
        service.crearAnimal(new Animal("Gloria", "Hipopótamo", 7, "Pantano", LocalDate.of(2022, 1, 5)));
        service.crearAnimal(new Animal("Alex", "León", 8, "Sabana", LocalDate.of(2019, 8, 20)));

        // Consultas

        System.out.println("Animales por especie 'León':");
        List<Animal> leones = service.animalesPorEspecie("León");
        leones.forEach(System.out::println);

        System.out.println("\nAnimales con edad 7:");
        List<Animal> edad7 = service.animalesPorEdad(7);
        edad7.forEach(a -> System.out.println(a.getEspecie() + " - " + a.getNombre() + " - " + a.getHabitat()));

        System.out.println("\nAnimales que ingresaron en los últimos 4 años:");
        List<Animal> ultimos4 = service.animalesDesdeAnyo(4);
        ultimos4.forEach(a -> System.out.println(a.getFechaIngreso() + " - " + a.getEspecie() + " - " + a.getNombre()));

        System.out.println("\nAnimales antes de 2020-01-01:");
        List<Animal> antes2020 = service.animalesAntesDeFecha(LocalDate.of(2020, 1, 1));
        antes2020.forEach(System.out::println);

        System.out.println("\nAnimales después de 2019-01-01:");
        List<Animal> despues2019 = service.animalesDespuesDeFecha(LocalDate.of(2019, 1, 1));
        despues2019.forEach(System.out::println);

        System.out.println("\nAnimales entre 2018-01-01 y 2020-12-31:");
        List<Animal> entreFechas = service.animalesEntreFechas(LocalDate.of(2018, 1, 1), LocalDate.of(2020, 12, 31));
        entreFechas.forEach(System.out::println);

        System.out.println("\nAnimales ordenados por fecha ingreso ascendente:");
        List<Animal> ordenAsc = service.animalesOrdenadosPorFechaIngreso(true);
        ordenAsc.forEach(System.out::println);

        System.out.println("\nNúmero de animales ingresados en 2019:");
        Long count2019 = service.contarAnimalesIngresadosEnAnyo(2019);
        System.out.println(count2019);
		
	} 
}
