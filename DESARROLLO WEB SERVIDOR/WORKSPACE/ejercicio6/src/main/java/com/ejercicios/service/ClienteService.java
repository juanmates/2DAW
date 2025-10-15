package com.ejercicios.service;

import java.util.List;
import java.util.Optional;

import com.ejercicios.modelo.Cliente;
import com.ejercicios.modelo.Direccion;

public interface ClienteService {

	List<Cliente> getAllClientes();

	Optional<Cliente> getClienteById(int id);

	void saveCliente(Cliente cliente);

	Cliente updateCliente(Cliente cliente, int id);

	Boolean deleteCliente(int id);

	Cliente actualizarDireccion(int id, Direccion nuevaDireccion);

	void ActualizarASevillaTodosClienteQueEmpiecenPorA();

}
