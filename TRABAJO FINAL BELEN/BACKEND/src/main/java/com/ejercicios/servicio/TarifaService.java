package com.ejercicios.servicio;

import java.util.List;

import com.ejercicios.modelo.Tarifa;

public interface TarifaService {
	
	///////////////////////////////////
	
	//				CRUD

	Tarifa crearActualizarTarifa(Tarifa entidad);
	
	List<Tarifa> listarTodasLasTarifas();
	
	Tarifa buscarTarifaPorId(Long id);
	
	void eliminarTarifaSegunid(Long id);
	
	/////////////////////////////////
	
	//Listar tarifas según el tipo de carnet
	List<Tarifa> buscarPorTipoPermiso(String permiso);
	
	//Calcular el presupuesto estimado:
	//MATRICULA + (PRECIO CLASE * NUMERO DE CLASES)
	Double calcularPresupuestoEstimado(Long idTarifa, Integer numClases);
	
}
