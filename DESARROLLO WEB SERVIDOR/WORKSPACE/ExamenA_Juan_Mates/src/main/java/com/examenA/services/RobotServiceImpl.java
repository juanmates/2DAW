package com.examenA.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examenA.model.Robot;
import com.examenA.repository.RobotRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RobotServiceImpl implements RobotService{

	@Autowired
	RobotRepository robotRepositorio;
	
	@Override
	public Robot crearRobot(Robot r) {
		return robotRepositorio.save(r);
	}

	@Override
	public List<Robot> listarRobots() {
		// TODO Auto-generated method stub
		return robotRepositorio.findAll();
	}

	@Override
	public Robot buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return robotRepositorio.findById(id).orElse(null);
	}

	@Override
	public void eliminarRobot(Long id) {
		// TODO Auto-generated method stub
		robotRepositorio.deleteById(id);
	}

	@Override
	public Robot actualizarRobot(Robot r) {
		// TODO Auto-generated method stub
		return robotRepositorio.save(r);
	}

	@Override
	public List<Robot> buscarPorCategoria(String categoria) {
		// TODO Auto-generated method stub
		return robotRepositorio.findByCategoria(categoria);
	}

	@Override
	public List<Robot> buscarPorAnioFabricacion(Integer start, Integer end) {
		// TODO Auto-generated method stub
		return robotRepositorio.findByAnioFabricacionBetween(start, end);
	}

	@Override
	public long contarOperativos() {
		// TODO Auto-generated method stub
		return robotRepositorio.countByOperativoTrue();
	}

	@Override
	public List<Robot> obtenerBateriaCritica(Double nivelCritico) {
		// TODO Auto-generated method stub
		return robotRepositorio.findByNivelBateriaLessThan(nivelCritico);
	}

	@Override
	public List<Robot> buscarPorModeloOCategoria(String cadena) {
		// TODO Auto-generated method stub
		return robotRepositorio.buscarPorModeloOCategoria(cadena);
	}

	@Override
	public boolean existePorModelo(String modelo) {
		// TODO Auto-generated method stub
		return robotRepositorio.existsByModelo(modelo);
	}

	@Override
	public Robot obtenerRobotMasAntiguo() {
		// TODO Auto-generated method stub
		return robotRepositorio.findTop1ByOrderByAnioFabricacionDesc();
	}

}
