package com.ejercicios.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ejercicios.modelo.Cliente;
import com.ejercicios.modelo.Direccion;
import com.ejercicios.repositorio.ClienteRepository;
import com.ejercicios.repositorio.DireccionRepository;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class ClienteServiceIml implements ClienteService{
	
	@Autowired
	private ClienteRepository repositorio;
	private DireccionRepository repositorioDireccion;

	@Override
	public List<Cliente> getAllClientes() {
		// TODO Auto-generated method stub
		return repositorio.findAll();
	}

	@Override
	public Optional<Cliente> getClienteById(int id) {
		// TODO Auto-generated method stub
		return repositorio.findById(id); // orElse(null)
	}

	@Override
	public void saveCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		// sin usar cascade
		Direccion direccion = cliente.getDireccion();
		if(direccion != null) {
			repositorioDireccion.save(direccion);
		}
		repositorio.save(cliente); // si hay cascade solo pongo esta linea
	}
	
	@Override
	public Cliente updateCliente(Cliente cliente, int id) {
		// TODO Auto-generated method stub
		Cliente clienteAModificar = repositorio.findById(id).orElse(null);
		if(clienteAModificar == null) {
			return null;
		}
		clienteAModificar.setNombre(cliente.getNombre());
		Direccion nuevaDireccion = cliente.getDireccion();
		if(nuevaDireccion != null) {
			nuevaDireccion.setId(clienteAModificar.getDireccion().getId());
			repositorioDireccion.save(nuevaDireccion);
			clienteAModificar.setDireccion(nuevaDireccion);
		}
		return repositorio.save(clienteAModificar);
	}

	@Override
	public Boolean deleteCliente(int id) {
		// TODO Auto-generated method stub
		Cliente cliente = repositorio.findById(id).orElse(null);
		if(cliente != null) {
			int direccion = cliente.getDireccion().getId();
			repositorioDireccion.deleteById(direccion);
			repositorio.delete(cliente);		
			return true;
		} else {
			return false;
		}
		
		
	}

	@Override
	public Cliente actualizarDireccion(int id, Direccion nuevaDireccion) {
		// TODO Auto-generated method stub
		Cliente cliente = repositorio.findById(id).orElse(null);
		if(cliente != null) {
			return null;
		}
		nuevaDireccion.setId(cliente.getDireccion().getId());
		repositorioDireccion.save(nuevaDireccion);
		cliente.setDireccion(nuevaDireccion);
		return repositorio.save(cliente);
		
	}

	@Override
	public void ActualizarASevillaTodosClienteQueEmpiecenPorA() {
		// TODO Auto-generated method stub
		repositorio.actualizarCiudadSevillaParaClientesConA();
		
	}



	
	

}
