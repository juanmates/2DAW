package com.ej16;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ej16.model.Deportista;
import com.ej16.model.Deporte;
import com.ej16.service.DeporteService;
import com.ej16.service.DeportistaService;

@SpringBootApplication
public class Ejercicio16Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Ejercicio16Application.class, args);
	}

	@Autowired
	DeportistaService deportistaService;
	
	@Autowired
	DeporteService deporteService;
	
		
	@Override
	public void run(String... args) throws Exception {
		 // Crear deportistas
        Deportista deportista1 = new Deportista();
        deportista1.setNombre("Lionel Messi");
        Deportista deportista2 = new Deportista();
        deportista2.setNombre("Serena Williams");
        
        
        deportista1 = deportistaService.crearDeportista(deportista1);
        deportista2 = deportistaService.crearDeportista(deportista2);       
        

       // Crear deportes
        Deporte futbol = new Deporte();
        futbol.setNombre("Fútbol");
        Deporte tenis = new Deporte();
        tenis.setNombre("Tenis");
        Deporte baloncesto = new Deporte();
        baloncesto.setNombre("Baloncesto");
        
        futbol= deporteService.crearDeporte(futbol);
        tenis= deporteService.crearDeporte(tenis);
        baloncesto= deporteService.crearDeporte(baloncesto);
        
        List<Deportista> todos = deportistaService.obtenerTodos();
        todos.forEach(System.out::println);
       
        deportistaService.agregarDeporte(deportista1.getId(), futbol);
        deportistaService.agregarDeporte(deportista1.getId(), baloncesto);
        deportistaService.agregarDeporte(deportista2.getId(), tenis);
        
        todos = deportistaService.obtenerTodos();
        todos.forEach(System.out::println);
       
        
        Deporte badminton = new Deporte();
        badminton.setNombre("Badminton");
        badminton= deporteService.crearDeporte(badminton);
        
        deportistaService.agregarDeporte(deportista2.getId(),badminton);
        
        System.out.println("Deportista 2: " + deportistaService.obtenerPorId(deportista2.getId()));
        
        deportistaService.eliminarDeporte(deportista1.getId(), futbol);
        System.out.println("Deportista 1 después de eliminar básquetbol: " + deportistaService.obtenerPorId(deportista1.getId()));
        
        
	}

}
