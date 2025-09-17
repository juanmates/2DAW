package com.prueba;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.prueba.modelo.Usuario;

@SpringBootApplication
public class PruebaApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(PruebaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Usuario usuario1 = new Usuario();
		usuario1.setNombre("Juan");
		usuario1.setId(1);
		usuario1.setEdad(23);
		usuario1.setCorreo("example@ceuandalucia.es");
		System.out.println(usuario1.getNombre());
		System.out.println(usuario1.getCorreo());
		System.out.println(usuario1.getEdad());
		System.out.println(usuario1.getId());
		System.out.println(usuario1);
		
	}

}
