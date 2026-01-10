package com.ejercicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ejercicios.modelo.Hotel;
import com.ejercicios.servicio.HotelService;

@SpringBootApplication
public class Ejercicio4Application implements CommandLineRunner {

	@Autowired
	HotelService hotelService;

	public static void main(String[] args) {
		SpringApplication.run(Ejercicio4Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		hotelService.guardarHotel(new Hotel("Hotel Sol", "Calle Luna 12", 3, "123456789", "http://sol.com"));
		hotelService.guardarHotel(new Hotel("Hotel Mar", "Avenida Oceano 45", 5, "987654321", null));
		hotelService
				.guardarHotel(new Hotel("Hotel Estrella", "Plaza Central 1", 4, "112233445", "http://estrella.com"));
		hotelService.guardarHotel(new Hotel("Hotel Luna", "Calle Luna 34", 5, "223344556", ""));
		hotelService.guardarHotel(new Hotel("Hotel Oasis", "Boulevard Verde 7", 2, "667788990", "http://oasis.com"));

		System.out.println("\n--- Hoteles por estrellas desc y nombre asc ---");
		for (Hotel h : hotelService.hotelesOrdenadosPorEstrellasYNombre()) {
			System.out.println(h);
		}
		
		System.out.println("\n--- Hoteles con 5 estrellas ---");
		for (Hotel h : hotelService.buscarPorEstrellas(5)) {
			System.out.println(h);
		}

		System.out.println("\n--- Hoteles con estrellas entre 3 y 5 ---");
		for (Hotel h : hotelService.buscarRangoEstrellas(3, 5)) {
			System.out.println(h);
		}

		System.out.println("\n--- Los 3 hoteles con más estrellas ---");
		for (Hotel h : hotelService.tresMasEstrellas()) {
			System.out.println(h);
		}

		System.out.println("\n--- Hoteles que contienen 'Luna' en nombre o dirección ---");
		for (Hotel h : hotelService.buscarNombreoDireccion("Luna")) {
			System.out.println(h);
		}

		System.out.println("\n--- Número de hoteles con 5 estrellas ---");
		System.out.println(hotelService.contarPorEstrellas(5));

		System.out.println("\n--- Hoteles sin página web ---");
		for (Hotel h : hotelService.hotelesSinWeb()) {
			System.out.println(h);
		}
	}
}
