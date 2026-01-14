package com.examenA.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.examenA.model.Robot;

public interface RobotRepository extends JpaRepository<Robot, Long>{

	List<Robot> findByCategoria(String categoria);
	
	List<Robot> findByAnioFabricacionBetween(Integer start, Integer end);
	
	long countByOperativoTrue();
	
	List<Robot> findByNivelBateriaLessThan(Double nivelCritico);
	
	@Query("SELECT r FROM Robot r WHERE UPPER(r.modelo) LIKE UPPER('%cadena%') AND UPPER(r.categoria) LIKE UPPER('%cadena%')")
	List<Robot> buscarPorModeloOCategoria(@Param("cadena") String cadena);

	Boolean existsByModelo(String modelo);
	
	Robot findTop1ByOrderByAnioFabricacionDesc();
}
