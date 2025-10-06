package com.ejercicios.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejercicios.modelo.Cliente;
import com.ejercicios.repository.ClienteRepository;

import jakarta.transaction.Transactional;

@Transactional // SI HAY ALGUN PROBLEMA NO SE EJECUTA NADA (SETAUTOCOMMIT)
			   //SE PUEDE PONER DELANTE DEL METODO O EN LA CLASE
@Service	   
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
	private ClienteRepository repositorio;

	@Override
	public List<Cliente> getClientes() {
		return repositorio.findAll(); 
	}

	@Override
	public Optional<Cliente> getCliente(Integer id) {
		// TODO Auto-generated method stub
		return repositorio.findById(id);
	}

	@Override
	public void insertaCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		repositorio.save(cliente);		
	}

	@Override
	public void deleteCliente(Integer id) {
		// TODO Auto-generated method stub
		repositorio.deleteById(id);
	}

	@Override
	public Cliente actualizarCliente(Cliente clienteActualizado) {
		// TODO Auto-generated method stub
		Optional<Cliente> optCliente = repositorio.findById(clienteActualizado.getId());
		if(optCliente.isPresent()) {
			Cliente cliente = optCliente.get();
			cliente.setNombre(clienteActualizado.getNombre());
			cliente.setApellidos(clienteActualizado.getApellidos());
			return repositorio.save(cliente);
		}
		return null;
		
	}

	@Override
	public List<Cliente> getClientesNombre(String nombre) {
		// TODO Auto-generated method stub
		return repositorio.findByNombreContainingIgnoreCase(nombre);
	}

	@Override
	public List<Cliente> getClienteNombreyApellidos(String nombre, String apellidos) {
		// TODO Auto-generated method stub
		return repositorio.buscarPorNombreYApellidos(nombre, apellidos);
	}

	@Override
	public List<Cliente> getClientesOrdenadosApellidos() {
		// TODO Auto-generated method stub
		return repositorio.ordenPorApellidos();
	}

	@Override
	public long getNumeroCliente(String nombre) {
		// TODO Auto-generated method stub
		return repositorio.contarPorNombre(nombre);
	}

	@Override
	public List<Cliente> getClientesPrefijoSufijo(String cad1, String cad2) {
		// TODO Auto-generated method stub
		return repositorio.prefijoSufijo(cad1, cad2);
	}

}
