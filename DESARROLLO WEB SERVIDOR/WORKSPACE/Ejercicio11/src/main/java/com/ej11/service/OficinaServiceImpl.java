package com.ej11.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ej11.model.Empleado;
import com.ej11.model.Oficina;
import com.ej11.repository.EmpleadoRepository;
import com.ej11.repository.OficinaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class OficinaServiceImpl implements OficinaService {

	@Autowired
	private OficinaRepository oficinaRepo;
	
	@Autowired
	private EmpleadoRepository empleadoRepo;
	
	@Override
	public Oficina crear(Oficina oficina) {
		return oficinaRepo.save(oficina);
	}

	@Override
	public List<Oficina> listar() {
		return oficinaRepo.findAll();
	}

	public Oficina buscarPorId(Integer id) {
		return oficinaRepo.findById(id).orElse(null);
	}

	@Override
	public void eliminar(Integer id) {
		oficinaRepo.deleteById(id);
	}

	@Override
	public Integer contarEmpleados(Integer oficinaId) {
		
		Oficina o = buscarPorId(oficinaId);
        return o != null ? o.getEmpleados().size() : 0;
        
	}

	@Override
	public Map<Integer, Integer> mapaOficinasConCantidad() {
		List<Oficina> oficinas = oficinaRepo.findAll();
		Map<Integer, Integer> resultado = new HashMap<>();

		for (Oficina ofi : oficinas) {
			Integer num = contarEmpleados(ofi.getId());
			resultado.put(ofi.getId(), num);
		}

		return resultado;
	}

	@Override
	public List<Oficina> oficinasConMasDeN(int n) {
		List<Oficina> oficinas = oficinaRepo.findAll();
		List<Oficina> resultado = new ArrayList<>();

		for (Oficina oficina : oficinas) {
			int numEmpleados = contarEmpleados(oficina.getId()); // o long a int
			if (numEmpleados > n) {
				resultado.add(oficina);
			}
		}

		return resultado;
	}

	@Override
	public void actualizarTelefonoPorEmpleadoId(Integer empleadoId, String nuevoTelefono) {

		Empleado e = empleadoRepo.findById(empleadoId).orElse(null);
        if (e != null && e.getOficina() != null) {
            Oficina oficina = e.getOficina();
            oficina.setTelefono(nuevoTelefono);
            oficinaRepo.save(oficina);
        }

	}
}
