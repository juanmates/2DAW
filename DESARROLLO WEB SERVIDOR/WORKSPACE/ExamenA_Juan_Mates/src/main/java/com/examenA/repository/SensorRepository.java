package com.examenA.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.examenA.model.Sensor;


public interface SensorRepository extends JpaRepository<Sensor, Long>{
	
	@Query("SELECT s FROM Sensor s WHERE s.activo = true AND s.consumoEnegia < :maxConsumo")
	List<Sensor> activosBajoConsumo(@Param("maxConsumo") Double maxConsumo);
	
	
	@Query("SELECT s FROM Sensor s WHERE s.activo = true ORDER BY s.consumoEnegia ASC")
	List<Sensor> activosOrdenadosPorConsumo();
	
	
	@Query("SELECT s FROM Sensor s WHERE s.tipo = 'camara' AND s.rangoMaximo > :rangoMin")
	List<Sensor> tipoCamaraConRango(@Param("rangoMin") Double rangoMin);


}
