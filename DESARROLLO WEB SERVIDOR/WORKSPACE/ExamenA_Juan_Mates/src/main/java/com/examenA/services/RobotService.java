package com.examenA.services;

import java.util.List;

import com.examenA.model.Robot;
import com.examenA.model.Sensor;

public interface RobotService {
	Robot crearRobot(Robot r);

	List<Robot> listarRobots();

	Robot buscarPorId(Long id);

	void eliminarRobot(Long id);

	Robot actualizarRobot(Robot r);

	List<Robot> buscarPorCategoria(String categoria);

	List<Robot> buscarPorAnioFabricacion(Integer start, Integer end);

	long contarOperativos();

	List<Robot> obtenerBateriaCritica(Double nivelCritico);

	List<Robot> buscarPorModeloOCategoria(String cadena);

	boolean existePorModelo(String modelo);
	
	Robot obtenerRobotMasAntiguo();
	
}

