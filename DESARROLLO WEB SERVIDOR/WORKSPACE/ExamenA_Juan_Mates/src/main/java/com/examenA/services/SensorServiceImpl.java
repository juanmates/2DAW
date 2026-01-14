package com.examenA.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examenA.model.Robot;
import com.examenA.model.Sensor;
import com.examenA.repository.RobotRepository;
import com.examenA.repository.SensorRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class SensorServiceImpl implements SensorService{
	
	@Autowired
	SensorRepository sensorRepositorio;
	
	@Autowired
	RobotRepository robotRepositorio;

	@Override
	public Sensor agregarSensor(Long robotId, Sensor sensor) {
		// TODO Auto-generated method stub
		Robot r = robotRepositorio.findById(robotId).orElse(null);
		
		if(r!=null) {
			r.getSensores().add(sensor);
			robotRepositorio.save(r);
			sensor.setRobot(r);
		}
		
		return sensor;
	}

	@Override
	public List<Sensor> activosBajoConsumo(Double maxConsumo) {
		// TODO Auto-generated method stub
		return sensorRepositorio.activosBajoConsumo(maxConsumo);
	}

	@Override
	public List<Sensor> activosOrdenadosPorConsumo() {
		// TODO Auto-generated method stub
		return sensorRepositorio.activosOrdenadosPorConsumo();
	}

	@Override
	public List<Sensor> tipoCamaraConRango(Double rangoMin) {
		// TODO Auto-generated method stub
		return sensorRepositorio.tipoCamaraConRango(rangoMin);
	}

}
