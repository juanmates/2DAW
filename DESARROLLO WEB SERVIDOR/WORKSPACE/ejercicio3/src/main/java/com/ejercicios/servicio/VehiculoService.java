package com.ejercicios.servicio;

import java.util.List;
import java.util.Optional;

import com.ejercicios.modelo.Vehiculo;

public interface VehiculoService {

	Vehiculo crearVehiculo(Vehiculo v);
	
	Optional<Vehiculo> getVehiculoPorId(int id);
	
	List<Vehiculo> getVehiculos();
	
	Vehiculo actualizarVehiculo(int id, Vehiculo v);
	
	void eliminarVehiculo(int id);
	
	
	
}
