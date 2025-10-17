package com.ejercicios.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejercicios.modelos.Libro;

@RestController
@RequestMapping("/libros")
public class LibroResponseController {
	
	private List<Libro> libros = new ArrayList<>();
	
	
	List<String> generos1 = new ArrayList<>();
	List<String> generos2 = new ArrayList<>();
	List<String> generos3 = new ArrayList<>();
	List<String> generos4 = new ArrayList<>();
	
	
	private Libro l1 = new Libro(1, "Blancanieves", "Juan Mates", "Planeta", "AAA", 2002, generos1);
	private Libro l2 = new Libro(2, "Los 7 enanitos", "Manuel", "Anaya", "AAB", 2010, generos2);
	private Libro l3 = new Libro(3, "Rapunzel", "Jara Jaramillo", "Carioca", "AAC", 2012, generos3);
	private Libro l4 = new Libro(4, "EL lobo feroz", "Juan Mates", "Planeta", "AAD", 1962, generos4);
	
	public LibroResponseController() {
		
		generos1.add("Drama");
		generos1.add("Intriga");
		generos2.add("Thriller");
		generos2.add("Aventuras");
		generos3.add("Terror");
		generos3.add("Miedo");
		generos4.add("Suspense");
		generos4.add("Amor");
		
		libros.add(l1);
		libros.add(l2);
		libros.add(l3);
		libros.add(l4);
	}
	
	@GetMapping
	public ResponseEntity<List<Libro>> getLibros(){
		return ResponseEntity.ok(libros);
	}
	
	@GetMapping("/{titulo}")
	public ResponseEntity<Libro> getLibro(@PathVariable String titulo) {
		
		for (Libro libro : libros) {
			if(libro.getTitulo().equalsIgnoreCase(titulo)) {
				return ResponseEntity.ok(libro);
			}
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Libro> postLibro(@RequestBody Libro libro) {
		libros.add(libro);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping //Eliminar el objeto completo
	public ResponseEntity<Libro> putLibro(@RequestBody Libro modif) {
		for (Libro libro : libros) {
			if (libro.getId()==(modif.getId())) {
				libro.setTitulo(modif.getTitulo());
				libro.setAutor(modif.getAutor());
				libro.setEditorial(modif.getEditorial());
				libro.setIsbn(modif.getIsbn());
				libro.setAnyoPublicacion(modif.getAnyoPublicacion());
				libro.setGeneros(modif.getGeneros());
				return ResponseEntity.noContent().build();
			}
		}
		return ResponseEntity.notFound().build();
	}
	
	@PatchMapping  //Solo elimino los campos que no esten nulos
	public ResponseEntity<Libro> pathCliente(@RequestBody Libro modif) {
		for (Libro libro : libros) {
			if (libro.getId() == modif.getId()) {
				if (modif.getTitulo() != null) {
					System.out.println("Titulo");
					libro.setTitulo(modif.getTitulo());
				}
				if (modif.getAutor() != null) {
					System.out.println("Autor");
					libro.setAutor(modif.getAutor());
				}
				if (modif.getEditorial() != null) {
					System.out.println("Editorial");
					libro.setEditorial(modif.getEditorial());
				}
				if (modif.getIsbn() != null) {
					System.out.println("Isbn");
					libro.setIsbn(modif.getIsbn());
				}
				if (modif.getAnyoPublicacion() == 0) {
					System.out.println("Año de publicación");
					libro.setAnyoPublicacion(modif.getAnyoPublicacion());
				}
				if(modif.getGeneros() == null) {
					System.out.println("Generos");
					libro.setGeneros(modif.getGeneros());
				}
				return ResponseEntity.ok(libro);
			}

		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Libro> deleteCliente(@PathVariable int id) {
		Iterator<Libro> iterador = libros.iterator();
		while (iterador.hasNext()) {
			Libro libro = iterador.next();
			if (libro.getId() == id) {
				iterador.remove();
				return ResponseEntity.ok(libro);
			}
		}
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/libros/{novela}")
	public ResponseEntity<List<Libro>> ObtenerNovelas(){
		List<Libro> res = new ArrayList<>();
		for(Libro a:libros)	{
			for(String genero: a.getGeneros()) {
				if(genero.equals("novela")) {
					res.add(a);
				}
			}
		}
		return ResponseEntity.ok(res);
	}
	
	@GetMapping("/librosPorGenero/{genero}")
	public ResponseEntity<List<Libro>> ObtenerPorGenero(@PathVariable String genero){
		List<Libro> res = new ArrayList<>();
		for(Libro a:libros)	{
			for(String x: a.getGeneros()) {
				if(x.equals(genero)) {
					res.add(a);
				}
			}
		}
		return ResponseEntity.ok(res);
	}
	
	/*@GetMapping("/AutoresConMasdeXlibros/{numeroDeLibros}")
	public ResponseEntity<Map<String, Integer>> ObtenerAutoresConMasDeXLibros(@PathVariable Integer numeroDeLibros){
		Map<String, Integer> res = new HashMap<>();
		
		
		
		
	}*/
	
	
	
	
	
	
	

}
