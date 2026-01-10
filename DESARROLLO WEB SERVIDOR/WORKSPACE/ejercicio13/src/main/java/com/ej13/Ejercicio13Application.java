package com.ej13;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ej13.model.Autor;
import com.ej13.model.Libro;
import com.ej13.service.AutorService;
import com.ej13.service.LibroService;

@SpringBootApplication
public class Ejercicio13Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Ejercicio13Application.class, args);
	}

	@Autowired
	AutorService autorService;
	
	@Autowired
	LibroService libroService;

	@Override
	public void run(String... args) throws Exception {

		// 1. Insertar autores
		System.out.println("*** 1 **** ");
		Autor autor1 = new Autor("Gabriel Garcia Marquez");
		Autor autor2 = new Autor("J.K. Rowling");
		autorService.insertarAutor(autor1);
		autorService.insertarAutor(autor2);

		// 2. Insertar libros
		System.out.println("*** 2 **** ");
		Libro libro1 = new Libro("Cien Años de Soledad");
		Libro libro2 = new Libro("Harry Potter y la Piedra Filosofal");
		autorService.añadirLibro(autor1.getId(), libro1);
		autorService.añadirLibro(autor2.getId(), libro2);

		// 3. Mostrar todos los autores
		System.out.println("*** 3 **** ");
		System.out.println("Todos los autores:");
		autorService.obtenerAutores().forEach(System.out::println);

		// 4. Mostrar todos los libros
		System.out.println("*** 4 **** ");
		System.out.println("Todos los libros:");
		libroService.obtenerTodosLibros().forEach(System.out::println);

		// 5. Obtener autor por ID
		System.out.println("*** 5 **** ");
		System.out.println("Autor con ID 1:");
		System.out.println(autorService.obtenerAutor(autor1.getId()));

		// 6. Actualizar nombre de autor
		System.out.println("*** 6 **** ");
		Autor autorToUpdate = autorService.obtenerAutor(autor1.getId());
		autorToUpdate.setNombre("Gabriel Garcia Marquez Actualizado");
		autorService.actualizarAutor(autorToUpdate);

		// 7. Mostrar autor actualizado
		System.out.println("*** 7 **** ");
		System.out.println("Autor actualizado con ID 1:");
		Autor autorX = autorService.obtenerAutor(autor1.getId());
		System.out.println(autorX);

		// 8. Buscar autores por nombre
		System.out.println("*** 8 **** ");
		System.out.println("Autores cuyo nombre contiene 'Rowling':");
		autorService.autoresPorNombre("Rowling").forEach(System.out::println);

		// 9. Actualizar título de libro
		System.out.println("*** 9 **** ");

		autorX = autorService.obtenerAutor(autor2.getId());
		libroService.actualizarTituloLibro(autorX.getLibros().get(0).getId(), "Harry Potter y la Cámara Secreta");

		// 10. Mostrar libro actualizado
		System.out.println("*** 10 **** ");
		System.out.println("Libros:");
		libroService.obtenerTodosLibros().forEach(System.out::println);

		// 11. Eliminar autor
		System.out.println("*** 11 **** ");
		autorService.eliminarAutor(autor2.getId());

		// 12. Mostrar todos los autores después de la eliminación
		System.out.println("*** 12 **** ");
		System.out.println("Todos los autores después de la eliminación:");
		autorService.obtenerAutores().forEach(System.out::println);
	}

}
