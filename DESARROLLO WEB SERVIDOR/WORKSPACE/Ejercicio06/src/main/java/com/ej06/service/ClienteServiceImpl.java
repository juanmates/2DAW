package com.ej06.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ej06.model.Cliente;
import com.ej06.model.Direccion;
import com.ej06.repository.ClienteRepository;
import com.ej06.repository.DireccionRepository;

import jakarta.persistence.EntityManager;
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
		// sin usar cascade
		Direccion direccion = cliente.getDireccion();
		if (direccion != null) {
			direccionRepository.save(direccion);
		}
		clienteRepository.save(cliente);

		// usando cascade:
		// return clienteRepository.save(cliente);
	}

	@Override
	public Cliente updateCliente(Integer idCliente, Cliente clienteDetails) {

		Cliente cliente = getClienteById(idCliente);
		if (cliente == null)
			return null;

		cliente.setNombre(clienteDetails.getNombre());

		Direccion nuevaDireccion = clienteDetails.getDireccion();
		if (nuevaDireccion != null) {
			nuevaDireccion.setId(cliente.getDireccion().getId());
			direccionRepository.save(nuevaDireccion);
			cliente.setDireccion(nuevaDireccion);
		}

		return clienteRepository.save(cliente);
	}

	@Override
	public Boolean deleteCliente(Integer id) {
		Cliente cliente = getClienteById(id);
		if (cliente != null) {
			Integer idDireccion = cliente.getDireccion().getId();
			clienteRepository.delete(cliente);
			direccionRepository.deleteById(idDireccion);
			return true;
		}
		return false;
	}

	@Override
	public Cliente actualizarDireccion(Integer idCliente, Direccion nuevaDireccion) {

		Cliente cliente = getClienteById(idCliente);
		if (cliente == null) {
			return null;
		}
		nuevaDireccion.setId(cliente.getDireccion().getId());
		direccionRepository.save(nuevaDireccion);
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
				direccionRepository.save(direccion); // Si no hay cascade
			}
		}
	}

	@Override
	public void actualizarCiudadPorNombre(String letra, String ciudad) {
		List<Cliente> clientes = clienteRepository.findByNombreStartingWithIgnoreCase(letra);
		System.out.println(clientes.size());
		for (Cliente cliente : clientes) {
			if (cliente.getDireccion() != null) {
				cliente.getDireccion().setCiudad(ciudad);
				clienteRepository.save(cliente);
			}
		}
	}
	@Override
	public List<Cliente> findClientesByCiudad(String ciudad) {
		return clienteRepository.findByDireccionCiudad(ciudad);
	}

}
