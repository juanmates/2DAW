package com.ejercicios.servicio;

import java.util.List;

import com.ejercicios.modelo.Direccion;

public interface DireccionService {
	
	/////////////////////////////////////////////////////
	
	
	// 	CRUD
	
	Direccion crearActualizarDireccion(Direccion entidad);
	
	List<Direccion> listarTodasLasDirecciones();
	
	Direccion buscarDireccionPorId(Long id);
	
	void eliminarDireccionSegunId(Long id);
	
	/////////////////////////////////////////////////////

	//Obtener la direccion formateada
	String obtenerDireccionFormateada(Long id);
	
	//Filtrar las direcciones que pertenecen a una provincia especifica
	List<Direccion> fitrarPorProvincia(String provincia);
	
	// Buscar direcciones por rango de códigos postales
	List<Direccion> buscarPorRangoCP(String inicio, String fin);
	
	// Obtener el nombre de la autoescuela asociada a esa direccion
	String obtenerNombreAutoescuelaAsociada(Long id);
	
}
