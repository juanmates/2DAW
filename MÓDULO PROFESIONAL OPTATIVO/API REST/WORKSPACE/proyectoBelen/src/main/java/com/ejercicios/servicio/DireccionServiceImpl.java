package com.ejercicios.servicio;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejercicios.modelo.Direccion;
import com.ejercicios.repositorio.DireccionRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class DireccionServiceImpl implements DireccionService{
	
	@Autowired
	private DireccionRepository repositorio;

	@Override
	public Direccion crearActualizarDireccion(Direccion entidad) {
		// TODO Auto-generated method stub
		return repositorio.save(entidad);
	}

	@Override
	public List<Direccion> listarTodasLasDirecciones() {
		// TODO Auto-generated method stub
		return repositorio.findAll();
	}

	@Override
	public Direccion buscarDireccionPorId(Long id) {
		// TODO Auto-generated method stub
		return repositorio.findById(id).orElse(null);
	}

	@Override
	public void eliminarDireccionSegunId(Long id) {
		// TODO Auto-generated method stub
		repositorio.deleteById(id);
	}

	@Override
	public String obtenerDireccionFormateada(Long id) {
		// TODO Auto-generated method stub
		Direccion d = buscarDireccionPorId(id);
		if(d == null) {
			return "Dirección no encontrada";
		}
		return d.getCalle() + ", " + d.getCodigoPostal() + ", " + d.getCiudad();
	}

	@Override
	public List<Direccion> fitrarPorProvincia(String provincia) {
		// TODO Auto-generated method stub
		List<Direccion> todas = repositorio.findAll();
		return todas.stream().filter(d -> d.getProvincia()
				.equalsIgnoreCase(provincia)).collect(Collectors.toList());
	}

	@Override
	public List<Direccion> buscarPorRangoCP(String inicio, String fin) {
		// TODO Auto-generated method stub
		List<Direccion> todas = repositorio.findAll();
		List<Direccion> res = new ArrayList<>();
		for(Direccion d : todas) {
			if(d.getCodigoPostal() != null && 
					d.getCodigoPostal().compareTo(inicio) >=0 
					&& d.getCodigoPostal().compareTo(fin) <= 0) {
				res.add(d);
			}
		}
		return res;
	}

	@Override
	public String obtenerNombreAutoescuelaAsociada(Long id) {
		// TODO Auto-generated method stub
		Direccion d = buscarDireccionPorId(id);
		if(d != null && d.getAutoescuela() != null) {
			return d.getAutoescuela().getNombre();
		}
		return "Sin autoescuela asociada";
	}

}
