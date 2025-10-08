package com.ejercicios.servicio;

import java.util.List;

import com.ejercicios.modelo.Vehiculo;

public interface VehiculoService {

	void crearVehiculo(Vehiculo v);
	
	Vehiculo getVehiculoPorId(int id);
	
	List<Vehiculo> getVehiculos();
	
	void actualizarVehiculo(int id, Vehiculo v);
	
	void eliminarVehiculo(int id);
	
	
	
}
