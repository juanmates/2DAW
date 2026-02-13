package com.ejercicios.servicio;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejercicios.modelo.Vehiculo;
import com.ejercicios.repositorio.VehiculoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class VehiculoServiceImpl implements VehiculoService{
	
	@Autowired
	private VehiculoRepository repositorio;

	@Override
	public Vehiculo crearActualizarVehiculo(Vehiculo entidad) {
		// TODO Auto-generated method stub
		return repositorio.save(entidad);
	}

	@Override
	public List<Vehiculo> listarTodosLosVehiculos() {
		// TODO Auto-generated method stub
		return repositorio.findAll();
	}

	@Override
	public Vehiculo buscarVehiculoPorId(Long id) {
		// TODO Auto-generated method stub
		return repositorio.findById(id).orElse(null);
	}

	@Override
	public void eliminarVehiculoSegunId(Long id) {
		// TODO Auto-generated method stub
		repositorio.deleteById(id);
	}

	@Override
	public Vehiculo buscarPorMatricula(String matricula) {
		// TODO Auto-generated method stub
		List<Vehiculo> todos = repositorio.findAll();
		for(Vehiculo v : todos) {
			if(v.getMatricula() != null && v.getMatricula().equalsIgnoreCase(matricula)) {
				return v;
			}
		}
		return null;
	}

	@Override
	public List<Vehiculo> filtrarPorTipoPermiso(String tipoPermiso) {
		// TODO Auto-generated method stub
		List<Vehiculo> todos = repositorio.findAll();
		return todos.stream().filter(v -> v.getTipo_permiso() != null 
		&& v.getTipo_permiso().equalsIgnoreCase(tipoPermiso))
		.collect(Collectors.toList());
	}

	@Override
	public List<Vehiculo> buscarVehiculosPorAutoescuela() {
		// TODO Auto-generated method stub
		List<Vehiculo> todos = repositorio.findAll();
		List<Vehiculo> res = new ArrayList<>();
		for(Vehiculo v : todos) {
			if(v.getAutoescuela_vehiculos() != null) {
				res.add(v);
			}
		}
		return res;
	}

}
