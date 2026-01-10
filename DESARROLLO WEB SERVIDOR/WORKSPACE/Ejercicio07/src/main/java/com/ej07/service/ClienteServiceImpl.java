package com.ej07.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.ej07.model.Cliente;
import com.ej07.model.Direccion;
import com.ej07.repository.ClienteRepository;
import com.ej07.repository.DireccionRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private DireccionRepository direccionRepository;

	@Override
	public List<Cliente> getAllClientes() {
		return clienteRepository.findAll();
	}

	@Override
	public Cliente getClienteById(Integer id) {
		return clienteRepository.findById(id).orElse(null);
	}

	@Override
	public void saveCliente(Cliente cliente) {
		if (cliente.getDireccion() != null) {
			cliente.getDireccion().setClient(cliente); // ← sincronizar relación
		}
		clienteRepository.save(cliente);
	}

	@Override
	public Cliente updateCliente(Integer idCliente, Cliente clienteDetails) {

		Cliente cliente = getClienteById(idCliente);
		if (cliente == null)
			return null;

		cliente.setNombre(clienteDetails.getNombre());

		Direccion nuevaDireccion = clienteDetails.getDireccion();
		if (nuevaDireccion != null) {
			nuevaDireccion.setClient(cliente);
			cliente.setDireccion(nuevaDireccion);
		}

		return clienteRepository.save(cliente);
	}

	@Override
	public Boolean deleteCliente(Integer id) {
		Cliente cliente = getClienteById(id);
		if (cliente != null) {
			clienteRepository.delete(cliente);
			return true;
		}
		return false;
	}

	@Override
	public Cliente actualizarDireccion(Integer idCliente, Direccion nuevaDireccion) {

		Cliente cliente = getClienteById(idCliente);
		if (cliente == null)
			return null;

		nuevaDireccion.setClient(cliente);
		cliente.setDireccion(nuevaDireccion);
		return clienteRepository.save(cliente);

		/*
		 * Cliente cliente = clienteRepository.findById(idCliente); if (cliente != null)
		 * { if (nuevaDireccion != null) {
		 * nuevaDireccion.setId(cliente.getDireccion().getId());
		 * cliente.setDireccion(nuevaDireccion); clienteRepository.save(cliente); return
		 * cliente; } } return null;
		 */
	}

	@Override
	public void actualizarCiudadSevillaNombresA() {

		List<Cliente> clientes = clienteRepository.findByNombreStartingWithIgnoreCase("A");

		for (Cliente cliente : clientes) {
			Direccion direccion = cliente.getDireccion();
			if (direccion != null) {
				direccion.setCiudad("Sevilla");
				direccion.setClient(cliente);
				cliente.setDireccion(direccion);
				clienteRepository.save(cliente);
			}
		}
	}

	@Override
	public void actualizarCiudadPorNombre(String letra, String ciudad) {
		List<Cliente> clientes = clienteRepository.findByNombreStartingWithIgnoreCase(letra);
		System.out.println(clientes.size());
		for (Cliente cliente : clientes) {
			Direccion direccion = cliente.getDireccion();
			if (direccion != null) {
				direccion.setCiudad(ciudad);

				// Mantener la relación bidireccional sincronizada
				direccion.setClient(cliente);
				cliente.setDireccion(direccion);
			}
			clienteRepository.save(cliente);
		}

	}

	@Override
	public List<Cliente> findClientesByCiudad(String ciudad) {
		return clienteRepository.findByDireccionCiudad(ciudad);
	}

}
