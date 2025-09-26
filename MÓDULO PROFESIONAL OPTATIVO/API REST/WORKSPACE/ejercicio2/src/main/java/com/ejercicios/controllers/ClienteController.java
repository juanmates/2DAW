package com.ejercicios.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ejercicios.modelo.Cliente;


@RestController
public class ClienteController {
	
		List<Cliente> clientes = new ArrayList<Cliente>();
		
		public ClienteController() {
			Cliente cliente1 = new Cliente(1, "Juan", "jmates", "1234");
			Cliente cliente2 = new Cliente(2, "Angel", "amelendez", "2345");
			Cliente cliente3 = new Cliente(3, "Manuel", "mlopez", "3456");
			Cliente cliente4 = new Cliente(4, "Ignacio", "ipuerta", "4567");
			
			clientes.add(cliente1);
			clientes.add(cliente2);
			clientes.add(cliente3);
			clientes.add(cliente4);
			
		}
		
		@GetMapping("/clientes")
		public List<Cliente> metodo1() {
			return clientes;
		}
		
		@GetMapping("/clientes/{username}")
		public Cliente metodo2(@PathVariable String username) {
			
			for (Cliente cliente: clientes) {
				if(cliente.getUsername().equals(username)) {
					return cliente;
				}
			}
			return null;
		}
		
		@PostMapping("/clientes")
		public void postCliente(@RequestBody Cliente cliente) {
			clientes.add(cliente);
		}
		
		@PutMapping("/clientes")
		public void putCliente(@RequestBody Cliente modif) {
			
			for(Cliente cliente: clientes) {
				if(cliente.getId()==modif.getId()) {
					cliente.setNombre(modif.getNombre());
					cliente.setUsername(modif.getUsername());
					cliente.setPassword(modif.getPassword());
					cliente.setId(modif.getId());
				}
			}
		}
		

}
