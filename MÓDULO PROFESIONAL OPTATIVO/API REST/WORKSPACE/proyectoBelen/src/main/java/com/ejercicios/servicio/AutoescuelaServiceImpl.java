package com.ejercicios.servicio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejercicios.modelo.Autoescuela;
import com.ejercicios.modelo.Resenya;
import com.ejercicios.modelo.Tarifa;
import com.ejercicios.modelo.Vehiculo;
import com.ejercicios.repositorio.AutoescuelaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AutoescuelaServiceImpl implements AutoescuelaService{
	
	@Autowired
	private AutoescuelaRepository repositorio;

	@Override
	public Autoescuela crearActualizarAutoescuela(Autoescuela entidad) {
		// TODO Auto-generated method stub
		return repositorio.save(entidad);
	}

	@Override
	public List<Autoescuela> listarTodasLasAutoescuelas() {
		// TODO Auto-generated method stub
		return repositorio.findAll();
	}

	@Override
	public Autoescuela buscarAutoescuelaPorId(Long id) {
		// TODO Auto-generated method stub
		return repositorio.findById(id).orElse(null);
	}

	@Override
	public void eliminarAutoescuelaSegunId(Long id) {
		// TODO Auto-generated method stub
		repositorio.deleteById(id);
	}

	@Override
	public List<Autoescuela> buscarPorCiudad(String ciudad) {
		// TODO Auto-generated method stub
		return repositorio.findByDireccionCiudadIgnoreCase(ciudad);
	}

	@Override
	public Double obtenerPrecioMinimo(Long autoescuelaId) {
		// TODO Auto-generated method stub
		Autoescuela a = buscarAutoescuelaPorId(autoescuelaId);
		if(a == null || a.getTarifas() == null || a.getTarifas().isEmpty()) {
			return 0.0;
		}
		return a.getTarifas().stream().mapToDouble(Tarifa::getPrecio_matricula).min().orElse(0.0);
	}

	@Override
	public Double calcularPuntuacionMedia(Long autoescuelaId) {
		// TODO Auto-generated method stub
		Autoescuela a = buscarAutoescuelaPorId(autoescuelaId);
		if(a == null || a.getResenyas() == null) {
			return 0.0;
		}
		return a.getResenyas().stream().mapToDouble(Resenya::getPuntuacion).average().orElse(0.0);
	}

	@Override
	public List<Autoescuela> buscarPorCodigoPostal(String cp) {
		// TODO Auto-generated method stub
		List<Autoescuela> todas = repositorio.findAll();
		List<Autoescuela> res = new ArrayList<>();
		for(Autoescuela a: todas) {
			if(a.getDireccion() != null && cp.equals(a.getDireccion().getCodigoPostal())) {
				res.add(a);
			}
		}
		return res;
	}

	@Override
	public Long contarVehiculosPorPermiso(Long autoescuelaId, String tipoPermiso) {
		// TODO Auto-generated method stub
		Autoescuela a = buscarAutoescuelaPorId(autoescuelaId);
		Long contador = 0L;
		if(a != null && a.getVehiculos() != null) {
			for(Vehiculo v : a.getVehiculos()) {
				if(v.getTipo_permiso().equalsIgnoreCase(tipoPermiso)) {
					contador++;
				}
			}
		}
		return contador;
	}

	@Override
	public List<Tarifa> obtenerTarifasPorPermiso(Long id, String permiso) {
		// TODO Auto-generated method stub
		Autoescuela a = buscarAutoescuelaPorId(id);
		if(a == null || a.getTarifas() == null) {
			return Collections.emptyList();
		}
		return a.getTarifas().stream()
				.filter(t -> t.getTipo_permiso().equals(permiso)).collect(Collectors.toList());
	}

	@Override
	public Boolean tieneVehiculosResgistrados(Long id) {
		// TODO Auto-generated method stub
		Autoescuela a = buscarAutoescuelaPorId(id);
		if (a != null && a.getVehiculos() != null) {
			if (a.getVehiculos().size() > 0) {
				return true;
			}
		}
		return false;
	}

	@Override
	public List<Resenya> obtenerResenyasCriticas(Long id) {
		// TODO Auto-generated method stub
		Autoescuela a = buscarAutoescuelaPorId(id);
		List<Resenya> criticas = new ArrayList<>();
		if( a != null && a.getResenyas() != null) {
			for(Resenya r : a.getResenyas()) {
				if(r.getPuntuacion() < 3) {
					criticas.add(r);
				}
			}
		}
		return criticas;
	}

	@Override
	public Resenya obtenerMejorComentario(Long id) {
		// TODO Auto-generated method stub
		Autoescuela a = buscarAutoescuelaPorId(id);
		if(a == null || a.getResenyas() == null || a.getResenyas().isEmpty()) {
			return null;
		}
		Resenya mejor = a.getResenyas().get(0);
		for ( Resenya r : a.getResenyas()) {
			if(r.getPuntuacion() > mejor.getPuntuacion()) {
				mejor = r;
			}
		}
		return mejor;
	}

	@Override
	public Map<String, Set<String>> obtenerMapaPermisosPorNombre(Long id) {
		// TODO Auto-generated method stub
		Autoescuela a = buscarAutoescuelaPorId(id);
		Map<String, Set<String>> mapa = new HashMap<>();
		if(a != null && a.getTarifas() != null) {
			Set<String> permisos = a.getTarifas().stream()
					.map(Tarifa::getTipo_permiso).collect(Collectors.toSet());
			mapa.put(a.getNombre(), permisos);
		}
		return mapa;
	}
}
