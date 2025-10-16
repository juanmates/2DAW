package com.ejercicios.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejercicios.modelos.Libro;

@RestController
@RequestMapping("/libros")
public class LibroResponseController {
	
	private List<Libro> libros = new ArrayList<>();
	
	
			

}
