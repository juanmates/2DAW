package com.ej10.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ej10.model.Empleado;
import com.ej10.repository.EmpleadoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
	private EmpleadoRepository repo;

    @Override
    public Empleado crear(Empleado e) {
        return repo.save(e);
    }

    @Override
    public List<Empleado> listar() {
        return repo.findAll();
    }

    @Override
    public Empleado buscarPorId(Integer id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Empleado actualizar(Empleado e) {
        
    		Empleado emp =buscarPorId(e.getId());
    		if(emp!=null)
    		{
    			emp.setEmail(e.getEmail());
    			emp.setNombre(e.getNombre());
    			emp.setPuesto(e.getPuesto());
    		}
    		return repo.save(emp);        
    }

    @Override
    public void eliminar(Integer id) {
        repo.deleteById(id);
    }

    @Override
    public List<Empleado> buscarPorPuesto(String puesto) {
        return repo.findByPuesto(puesto);
    }
}
