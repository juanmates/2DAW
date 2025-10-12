package com.ejercicios.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejercicios.modelo.Vehiculo;
import com.ejercicios.repository.VehiculoRepository;

import jakarta.transaction.Transactional;

@Transactional

@Service
public class VehiculoServiceImpl implements VehiculoService{
	
	@Autowired
	private VehiculoRepository repositorio;

	@Override
	public Vehiculo crearVehiculo(Vehiculo v) {
		// TODO Auto-generated method stub
		return repositorio.save(v);
	}

	@Override
	public Optional<Vehiculo> getVehiculoPorId(int id) {
		// TODO Auto-generated method stub
		return repositorio.findById(id);
	}

	@Override
	public List<Vehiculo> getVehiculos() {
		// TODO Auto-generated method stub
		return repositorio.findAll();
	}

	@Override
	public Vehiculo actualizarVehiculo(int id, Vehiculo v) {
		// TODO Auto-generated method stub
		Optional<Vehiculo> optCliente = repositorio.findById(v.getId());
		if(optCliente.isPresent()) {
			Vehiculo vehiculo = optCliente.get();
			vehiculo.setEstado(v.getEstado());
			vehiculo.setAnyo(v.getAnyo());
			vehiculo.setKilometraje(v.getKilometraje());
			vehiculo.setMarca(v.getMarca());
			vehiculo.setMatricula(v.getMatricula());
			vehiculo.setModelo(v.getModelo());			
			return repositorio.save(vehiculo);
		}
		return null;
	}

	@Override
	public void eliminarVehiculo(int id) {
		// TODO Auto-generated method stub
		repositorio.deleteById(id);
	}

}
