package com.ejercicios.servicio;

import java.util.List;

import com.ejercicios.modelo.Tarifa;

public interface TarifaService {

	Tarifa crearActualizarTarifa(Tarifa entidad);
	
	List<Tarifa> listarTodasLasTarifas();
	
	Tarifa buscarTarifaPorId(Long id);
	
	void eliminarTarifaSegunid(Long id);
	
}
