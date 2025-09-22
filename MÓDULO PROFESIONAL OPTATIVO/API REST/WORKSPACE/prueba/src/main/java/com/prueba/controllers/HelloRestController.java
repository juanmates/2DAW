package com.prueba.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {
	
	@GetMapping("/")
	public String inicio() {
		return "Me tienes que especificar el endpoint";
	}
	
	@GetMapping("/hola")
	public String hello() {
		return "Hello";
	}
	
	@GetMapping("/hola/{name}")
	public String holanombre(@PathVariable String name) {
		return "Hello " + name;
	}

}
