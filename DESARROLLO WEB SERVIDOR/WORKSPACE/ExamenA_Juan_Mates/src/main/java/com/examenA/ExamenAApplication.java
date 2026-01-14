package com.examenA;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.examenA.model.Robot;
import com.examenA.model.Sensor;
import com.examenA.services.RobotService;
import com.examenA.services.SensorService;


@SpringBootApplication
public class ExamenAApplication implements CommandLineRunner {

  
	@Autowired
	RobotService robotServicio;
	
	@Autowired
	SensorService sensorServicio;
	

	public static void main(String[] args) {
		SpringApplication.run(ExamenAApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("========= DATOS DE PRUEBA =========");
		
		Robot robot1 = new Robot("RX-9000", "industria", 2020, 87.5, true, 120.0);		
		robotServicio.crearRobot(robot1);
		System.out.println(robot1);
		
		//////////////////////////////////////
		
		Robot robot2 = new Robot("Explora-X1", "exploración", 2015, 15.0, true, 80.0);		
		robotServicio.crearRobot(robot2);
		
		//////////////////////////////////////
		
		Robot robot3 = new Robot("Rescue-77", "explorescateración", 2018, 10.2, false, 95.0);			
		robotServicio.crearRobot(robot3);
		
		///////////////////////////////////////
		
		robotServicio.listarRobots().forEach(t -> System.out.println(t));;
		
		////////////////////////////////////////
		
		//robotServicio.buscarPorId(1L);
		
		////////////////////////////////////////
		
		//System.out.println(robot1);
		
		
		
		Sensor sensor1 = new Sensor("temperatura", 0.1, "ºC", 200.0, 4.5, true);
		Sensor sensor2 = new Sensor("camara", 0.01, "px", 150.0, 8.0, true);
		Sensor sensor3 = new Sensor("proximidad", 0.5, "m", 30.0, 2.0, false);
		
		sensorServicio.agregarSensor(1L, sensor1);
		sensorServicio.agregarSensor(1L, sensor2);
		sensorServicio.agregarSensor(1L, sensor3);
		
		
		
		robotServicio.buscarPorAnioFabricacion(2010, 2019);
	}

}
