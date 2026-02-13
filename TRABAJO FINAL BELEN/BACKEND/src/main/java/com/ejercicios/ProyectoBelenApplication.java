package com.ejercicios;

import com.ejercicios.modelo.*;
import com.ejercicios.repositorio.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class ProyectoBelenApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProyectoBelenApplication.class, args);
    }

    @Bean
    public CommandLineRunner initData(AutoescuelaRepository autoRepo, 
                                     DireccionRepository dirRepo, 
                                     UsuarioRepository userRepo, 
                                     VehiculoRepository vehRepo, 
                                     TarifaRepository tarifaRepo, 
                                     ResenyaRepository resenyaRepo) {
        return args -> {
            if (autoRepo.count() > 0) return;

            // --- 1. USUARIOS (Más variados para las reseñas) ---
            Usuario u1 = userRepo.save(new Usuario(null, "ana@email.com", "1234", "Ana García", "ALUMNO", null, null));
            Usuario u2 = userRepo.save(new Usuario(null, "pepe@email.com", "1234", "Pepe López", "ALUMNO", null, null));
            Usuario u3 = userRepo.save(new Usuario(null, "carla@email.com", "1234", "Carla Ruiz", "ALUMNO", null, null));
            Usuario u4 = userRepo.save(new Usuario(null, "marcos@email.com", "1234", "Marcos Soler", "ALUMNO", null, null));
            Usuario u5 = userRepo.save(new Usuario(null, "lucia@email.com", "1234", "Lucía Sanz", "ALUMNO", null, null));

            // --- AUTOESCUELA 1: MONTERO (Madrid) ---
            Direccion d1 = dirRepo.save(new Direccion(null, "Calle Mayor 1", "28001", "Madrid", "Madrid", "1A", "España", null));
            Autoescuela a1 = autoRepo.save(new Autoescuela(null, "Autoescuela Montero", "B11111111", d1, null, null, null));
            
            // Flota diversificada
            vehRepo.save(new Vehiculo(null, "1111-AAA", "Seat Leon", "B - Manual", a1));
            vehRepo.save(new Vehiculo(null, "5555-FGH", "Tesla Model 3", "B - Automático", a1));
            vehRepo.save(new Vehiculo(null, "9999-KKK", "Kia Niro EV", "B - Eléctrico", a1));
            
            tarifaRepo.save(new Tarifa(null, "B", 150.0, 25.0, a1));
            resenyaRepo.save(new Resenya(null, 5.0, "Excelente trato, el Tesla es una maravilla.", a1, u1));
            resenyaRepo.save(new Resenya(null, 4.0, "Muy profesionales pero difícil aparcar cerca.", a1, u3));
            resenyaRepo.save(new Resenya(null, 5.0, "Aprobé el teórico a la primera gracias a sus tests.", a1, u5));

            // --- AUTOESCUELA 2: RUTA 66 (Barcelona) ---
            Direccion d2 = dirRepo.save(new Direccion(null, "Avenida Diagonal 22", "08001", "Barcelona", "Barcelona", "Bajo", "España", null));
            Autoescuela a2 = autoRepo.save(new Autoescuela(null, "Autoescuela Ruta 66", "B22222222", d2, null, null, null));
            
            vehRepo.save(new Vehiculo(null, "2222-BBB", "Volkswagen Golf", "B - Manual", a2));
            vehRepo.save(new Vehiculo(null, "6666-LMN", "Audi A3", "B - Manual", a2));
            
            tarifaRepo.save(new Tarifa(null, "B", 180.0, 30.0, a2));
            resenyaRepo.save(new Resenya(null, 4.0, "Muy profesionales y puntuales.", a2, u2));
            resenyaRepo.save(new Resenya(null, 3.5, "Los coches son nuevos pero las clases algo caras.", a2, u4));

            // --- AUTOESCUELA 3: STOP & GO (Sevilla) ---
            Direccion d3 = dirRepo.save(new Direccion(null, "Calle Betis 5", "41001", "Sevilla", "Sevilla", "Local", "España", null));
            Autoescuela a3 = autoRepo.save(new Autoescuela(null, "Autoescuela Stop & Go", "B33333333", d3, null, null, null));
            
            vehRepo.save(new Vehiculo(null, "3333-CCC", "Renault Clio", "B - Manual", a3));
            vehRepo.save(new Vehiculo(null, "7777-PQR", "Yamaha MT-07", "A2 - Moto", a3));
            vehRepo.save(new Vehiculo(null, "8888-STU", "Dacia Sandero", "B - Manual", a3));
            
            tarifaRepo.save(new Tarifa(null, "B", 200.0, 20.0, a3));
            tarifaRepo.save(new Tarifa(null, "A2", 150.0, 35.0, a3));
            resenyaRepo.save(new Resenya(null, 4.5, "Aprobé pronto el de moto. ¡Geniales!", a3, u1));
            resenyaRepo.save(new Resenya(null, 5.0, "El mejor precio por clase práctica de Sevilla.", a3, u2));

            // --- AUTOESCUELA 4: GIRALDA (Sevilla) ---
            Direccion d4 = dirRepo.save(new Direccion(null, "Calle Sierpes 10", "41002", "Sevilla", "Sevilla", "2B", "España", null));
            Autoescuela a4 = autoRepo.save(new Autoescuela(null, "Giralda Conducción", "B44444444", d4, null, null, null));
            
            vehRepo.save(new Vehiculo(null, "4444-DDD", "Peugeot 208", "B - Manual", a4));
            vehRepo.save(new Vehiculo(null, "0000-XYZ", "Honda CB500F", "A2 - Moto", a4));
            
            tarifaRepo.save(new Tarifa(null, "A2", 120.0, 35.0, a4));
            resenyaRepo.save(new Resenya(null, 5.0, "La mejor para el carnet de moto sin duda.", a4, u2));
            resenyaRepo.save(new Resenya(null, 4.0, "Profesores con mucha paciencia.", a4, u5));
            resenyaRepo.save(new Resenya(null, 3.0, "Mucha lista de espera para las prácticas.", a4, u3));

            // --- AUTOESCUELA 5: VELOCIDAD (Valencia) ---
            Direccion d5 = dirRepo.save(new Direccion(null, "Calle Colón 15", "46004", "Valencia", "Valencia", "1", "España", null));
            Autoescuela a5 = autoRepo.save(new Autoescuela(null, "Autoescuela Velocidad", "B55555555", d5, null, null, null));
            
            vehRepo.save(new Vehiculo(null, "5500-BBB", "Mini Cooper", "B - Manual", a5));
            vehRepo.save(new Vehiculo(null, "5511-CCC", "BMW i3", "B - Eléctrico", a5));
            
            tarifaRepo.save(new Tarifa(null, "B", 160.0, 28.0, a5));
            resenyaRepo.save(new Resenya(null, 5.0, "Aprender con un Mini es muy divertido.", a5, u4));
            resenyaRepo.save(new Resenya(null, 4.5, "Trato muy cercano y familiar.", a5, u1));

            System.out.println("--- BASE DE DATOS ACTUALIZADA CON ÉXITO ---");
        };
    }
}