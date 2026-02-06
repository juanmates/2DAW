package com.ejercicios.servicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejercicios.modelo.Resenya;
import com.ejercicios.repositorio.ResenyaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ResenyaServiceImpl implements ResenyaService{
	
	@Autowired
	private ResenyaRepository repositorio;

	@Override
	public Resenya crearActualizarResenya(Resenya entidad) {
		// TODO Auto-generated method stub
		return repositorio.save(entidad);
	}

	@Override
	public List<Resenya> listarTodasLasResenyas() {
		// TODO Auto-generated method stub
		return repositorio.findAll();
	}

	@Override
	public Resenya buscarResenyaPorId(Long id) {
		// TODO Auto-generated method stub
		return repositorio.findById(id).orElse(null);
	}

	@Override
	public void eliminarResenyaSegunId(Long id) {
		// TODO Auto-generated method stub
		repositorio.deleteById(id);
	}

	@Override
	public List<Resenya> buscarResenyasPorAutoescuela(Long idAutoescuela) {
		// TODO Auto-generated method stub
		List<Resenya> todas = repositorio.findAll();
		List<Resenya> res = new ArrayList<>();
		for(Resenya r : todas) {
			if(r.getAutoescuela_reservas() != null && 
			r.getAutoescuela_reservas().getId().equals(idAutoescuela)) {
				res.add(r);
			}
		}
		return res;
	}

	@Override
	public List<Resenya> buscarResenyasPorUsuario(Long idUsuario) {
		// TODO Auto-generated method stub
		List<Resenya> todas = repositorio.findAll();
		List<Resenya> res = new ArrayList<>();
		for (Resenya r : todas) {
			if (r.getUsuario_resenyas() != null && 
				r.getUsuario_resenyas().getId().equals(idUsuario)) {
				res.add(r);
			}
		}
		return res;
	}

	@Override
	public Map<Double, Integer> obtenerRecuentoPorPuntuacion(Long idAutoescuela) {
		// TODO Auto-generated method stub
		List<Resenya> resenyasAutoescuela = buscarResenyasPorAutoescuela(idAutoescuela);
		return resenyasAutoescuela.stream().collect(Collectors.groupingBy(Resenya::getPuntuacion, 
		Collectors.collectingAndThen(Collectors.counting(), Long::intValue)));
	}

}
