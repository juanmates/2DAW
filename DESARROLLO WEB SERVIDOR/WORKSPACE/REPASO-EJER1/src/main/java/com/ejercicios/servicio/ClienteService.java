package com.ejercicios.servicio;

import java.util.List;
import java.util.Optional;

import com.ejercicios.modelo.Cliente;

public interface ClienteService {
	
	//1
	List<Cliente> getClientes();
	
	//2
	Optional<Cliente> getCliente(int id);
	
	//3
	void insertaCliente(Cliente cliente);
	
	//4
	void deleteCliente(int id);
	
	//5
	Cliente actualizarCliente(Cliente cliente);
	
	//6
	List<Cliente> getClientesNombre(String nombre);
	
	//7
	List<Cliente> getClienteNombreyApellidos(String nombre, String apellidos);
	
	//8
	List<Cliente> getClientesOrdenadosApellido();
	
	//9
	int getNumeroCliente(String nombre);
	
	//10
	List<Cliente> getClientesPrefijoSufijo(String cad1, String cad2);
	
	

}
