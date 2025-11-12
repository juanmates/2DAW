package com.ejercicios.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PruebaController {

	@GetMapping("/")
	public String mostrarInicio() {
		return "index"; // busca templates/index.html
	}
	@GetMapping("/home")
	public String home(Model model) {
		
		model.addAttribute("mensaje", "Esto es un metodo en la página HOME");
		
		model.addAttribute("nombre", "<b>Mi nombre es Juan</b>");
		
		model.addAttribute("role", "admin");
		
		String[] nombres = {"Juan", "Carlos", "Angel", "Manuel", "Pepe"};
		model.addAttribute("nombres", nombres);
		
		return "home"; 
		
		
	}
	@GetMapping("/form")
	public String form() {
		return "form";
	}
	
}
