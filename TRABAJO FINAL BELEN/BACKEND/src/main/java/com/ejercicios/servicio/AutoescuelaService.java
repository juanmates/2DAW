package com.ejercicios.servicio;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ejercicios.modelo.Autoescuela;
import com.ejercicios.modelo.Resenya;
import com.ejercicios.modelo.Tarifa;

public interface AutoescuelaService {
	
	/////////////////////////////////////////////////////
	
	//				CRUD
	
	Autoescuela crearActualizarAutoescuela(Autoescuela entidad);
	
	List<Autoescuela> listarTodasLasAutoescuelas();
	
	Autoescuela buscarAutoescuelaPorId(Long id);
	
	void eliminarAutoescuelaSegunId(Long id);
	
	/////////////////////////////////////////////////////
	
	//	Filtra las autoescuelas según una ciudad especifica
	List<Autoescuela> buscarPorCiudad(String ciudad);
	
	// Devuelve el precio de matricula mas bajo
	Double obtenerPrecioMinimo(Long autoescuelaId);
	
	// Cálculo del promedio de de estrellas en la reseña de una autoescuela
	Double calcularPuntuacionMedia(Long autoescuelaId);
	
	//Filtra autoescuelas por CÓDIGO POSTAL
	List<Autoescuela> buscarPorCodigoPostal(String cp);
	
	//Filtra los vehiculos disponibles que hay por cada tipo de licencia
	Long contarVehiculosPorPermiso(Long autoescuelaId, String tipoPermiso);
	
	//Obetener tarifas por tipo de permiso
	List<Tarifa> obtenerTarifasPorPermiso(Long id, String permiso);
	
	//Verificar si la autoescuela tiene vehiculos registrados
	Boolean tieneVehiculosResgistrados(Long id);
	
	//Obtener solo las reseñas negativas (menos de 3 estrellas)
	List<Resenya> obtenerResenyasCriticas(Long id);
	
	// Obtener la reseña con mejor puntuación para destacar en el perfil
	Resenya obtenerMejorComentario(Long id);
	
	// Mapa cuya clave es el nombre de la autoescuela y su valor es la lista de permisos que tiene
	Map<String, Set<String>> obtenerMapaPermisosPorNombre(Long id);
}
