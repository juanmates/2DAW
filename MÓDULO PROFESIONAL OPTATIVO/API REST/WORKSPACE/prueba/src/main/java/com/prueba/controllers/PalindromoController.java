package com.prueba.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PalindromoController {

    private final HelloRestController helloRestController;


    PalindromoController(HelloRestController helloRestController) {
        this.helloRestController = helloRestController;
    }
	
	
	@GetMapping("/validar-palindromo/{palabra}")
	public String palindromo(@PathVariable String palabra) {
		String res = "";
		for(int i = palabra.length() - 1; i >= 0 ; i--) {
			res += palabra.substring(i, i+1);
		}
		
		if(res.equals(palabra)) {
			return "Es un palíndromo";
		}else {
			return "No es un palíndromo";
		}
	}

}
