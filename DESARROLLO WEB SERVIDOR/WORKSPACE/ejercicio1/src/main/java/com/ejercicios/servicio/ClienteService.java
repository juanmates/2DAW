package com.ejercicios.servicio;

import java.util.List;
import java.util.Optional;

import com.ejercicios.modelo.Cliente;

public interface ClienteService {
	
	List<Cliente> getClientes();
	
	Optional<Cliente> getCliente(Integer id);
	
	void insertaCliente(Cliente cliente);
	
	void deleteCliente(Integer id);
	
	Cliente actualizarCliente(Cliente clienteActualizado);
	
	List<Cliente> getClientesNombre(String nombre);
	
	List<Cliente> getClienteNombreyApellidos(String nombre, String apellidos);
	
	List<Cliente> getClientesOrdenadosApellidos();
	
	long getNumeroCliente(String nombre);
	
	List<Cliente> getClientesPrefijoSufijo(String cad1, String cad2);
	
	
	

}
