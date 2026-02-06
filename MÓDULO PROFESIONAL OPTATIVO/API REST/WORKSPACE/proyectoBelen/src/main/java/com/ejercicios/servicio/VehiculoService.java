package com.ejercicios.servicio;

import java.util.List;

import com.ejercicios.modelo.Vehiculo;

public interface VehiculoService {

	Vehiculo crearActualizarVehiculo(Vehiculo entidad);
	
	List<Vehiculo> listarTodosLosVehiculos();
	
	Vehiculo buscarVehiculoPorId(Long id);
	
	void eliminarVehiculoSegunId(Long id);
	
}
