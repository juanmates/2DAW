package com.ejercicios.servicio;

import java.util.List;
import java.util.Optional;

import com.ejercicios.modelo.Cliente;

public interface ClienteService {
	
	List<Cliente> getClientes();
	Optional<Cliente> getCliente(int id);
	void insertaCliente(Cliente cliente);
	void deleteCliente(int id);
	void actualizarCliente(Cliente cliente);
	List<Cliente> getClientesNombre(String nombre);
	List<Cliente> getClienteNombreyApellidos(String nombre, String apellidos);
	List<Cliente> getClientesOrdenadosApellidos();
	List<Cliente> getNumeroCliente(String nombre);
	List<Cliente> getClientesPrefijoSufijo(String cad1, String cad2);
	
	

}
