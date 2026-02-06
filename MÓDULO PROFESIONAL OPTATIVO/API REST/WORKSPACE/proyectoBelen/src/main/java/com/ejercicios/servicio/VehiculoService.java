package com.ejercicios.servicio;

import java.util.List;

import com.ejercicios.modelo.Vehiculo;

public interface VehiculoService {
	
	/////////////////////////////////////
	
	//				CRUD

	Vehiculo crearActualizarVehiculo(Vehiculo entidad);
	
	List<Vehiculo> listarTodosLosVehiculos();
	
	Vehiculo buscarVehiculoPorId(Long id);
	
	void eliminarVehiculoSegunId(Long id);
	
	///////////////////////////////////
	
	// Buscar vehículo por su matricula
	Vehiculo buscarPorMatricula(String matricula);
	
	// Filtrar vehiculos según el tipo de permiso
	List<Vehiculo> filtrarPorTipoPermiso(String tipoPermiso);
	
	//Obtener todos los vehiculos que pertenecen a una autoescuela específica
	List<Vehiculo> buscarVehiculosPorAutoescuela();
	
}
