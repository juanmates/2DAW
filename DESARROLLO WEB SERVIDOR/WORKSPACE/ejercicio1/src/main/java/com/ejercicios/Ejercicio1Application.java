package com.ejercicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ejercicios.modelo.Cliente;
import com.ejercicios.repository.ClienteRepository;
import com.ejercicios.servicio.ClienteService;

@SpringBootApplication
public class Ejercicio1Application implements CommandLineRunner {

    private final ClienteRepository clienteRepository;
	
	@Autowired
	ClienteService servicio;

    Ejercicio1Application(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

	public static void main(String[] args) {
		SpringApplication.run(Ejercicio1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("=== 1. Insertando clientes ===");
		servicio.insertaCliente(new Cliente("Pepe", "Martínez"));
		servicio.insertaCliente(new Cliente("Pepe", "González"));
		servicio.insertaCliente(new Cliente("Ana", "López"));
		servicio.insertaCliente(new Cliente("Pedro", "Sánchez"));
		servicio.insertaCliente(new Cliente("Pepa", "Ramírez"));
		servicio.insertaCliente(new Cliente("Pepa", "Matés"));
		
		System.out.println("Ya están inscrito todos los clientes");	
		
		System.out.println("\n=== 2. getCliente (por ID = 1) ===");
		System.out.println(servicio.getCliente(1));
		
		System.out.println("\n=== 3. deleteCliente (por ID = 2) ===");
		servicio.deleteCliente(2);
		
		System.out.println("\n=== 4. actualizarCliente (por ID = 1) ===");
		Cliente clienteActulizado = new Cliente("Pepe", "Martínez Actualizado");
		clienteActulizado.setId(1);
		servicio.actualizarCliente(clienteActulizado);
		System.out.println(servicio.getCliente(1));;
		
		System.out.println("\n=== 5. getClientesNombre (por nombre = P) ===");
		for( Cliente c: servicio.getClientesNombre("P")) {
			System.out.println(c);
		}
		
		System.out.println("\n=== 6. getClienteNombreyApellidos ===");
		for( Cliente c: servicio.getClienteNombreyApellidos("Pedro", "Sánchez")) {
			System.out.println(c);
		}
		
		System.out.println("\n=== 7. getClientesOrdenadosApellidos ===");
		for( Cliente c: servicio.getClientesOrdenadosApellidos()) {
			System.out.println(c);
		}
		
		System.out.println("\n=== 8. getNumeroCliente ===");
		System.out.println(servicio.getNumeroCliente("Pepa"));
		
		System.out.println("\n=== 9. getClientesPrefijoSufijo ===");
		for( Cliente c: servicio.getClientesPrefijoSufijo("P", "z")) {
			System.out.println(c);
		}
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
