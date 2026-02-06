package com.ejercicios.servicio;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejercicios.modelo.Tarifa;
import com.ejercicios.repositorio.TarifaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TarifaServiceImpl implements TarifaService{
	
	@Autowired
	private TarifaRepository repositorio;

	@Override
	public Tarifa crearActualizarTarifa(Tarifa entidad) {
		// TODO Auto-generated method stub
		return repositorio.save(entidad);
	}

	@Override
	public List<Tarifa> listarTodasLasTarifas() {
		// TODO Auto-generated method stub
		return repositorio.findAll();
	}

	@Override
	public Tarifa buscarTarifaPorId(Long id) {
		// TODO Auto-generated method stub
		return repositorio.findById(id).orElse(null);
	}

	@Override
	public void eliminarTarifaSegunid(Long id) {
		// TODO Auto-generated method stub
		repositorio.deleteById(id);
	}

	@Override
	public List<Tarifa> buscarPorTipoPermiso(String permiso) {
		// TODO Auto-generated method stub
		List<Tarifa> todas = repositorio.findAll();
		return todas.stream().filter(t -> t.getTipo_permiso() != null 
		&& t.getTipo_permiso().equalsIgnoreCase(permiso))
		.collect(Collectors.toList());
	}

	@Override
	public Double calcularPresupuestoEstimado(Long idTarifa, Integer numClases) {
		// TODO Auto-generated method stub
		Tarifa t = buscarTarifaPorId(idTarifa);
		if(t == null) {
			return 0.0;
		}
		Double total = t.getPrecio_matricula() + (t.getPrecio_clase() * numClases);
		return total;
	}

	
}
