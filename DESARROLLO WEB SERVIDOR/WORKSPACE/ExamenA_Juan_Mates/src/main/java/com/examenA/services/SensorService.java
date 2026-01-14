package com.examenA.services;

import java.util.List;

import com.examenA.model.Sensor;

public interface SensorService {

	
	Sensor agregarSensor(Long robotId, Sensor sensor);

	List<Sensor> activosBajoConsumo(Double maxConsumo);

	List<Sensor> activosOrdenadosPorConsumo();

	List<Sensor> tipoCamaraConRango(Double rangoMin);
}