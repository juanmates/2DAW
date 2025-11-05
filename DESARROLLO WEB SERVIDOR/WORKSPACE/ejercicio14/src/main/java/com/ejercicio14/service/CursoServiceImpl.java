package com.ejercicio14.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejercicio14.model.Curso;
import com.ejercicio14.model.Estudiante;
import com.ejercicio14.repository.CursoRepository;
import com.ejercicio14.repository.EstudianteRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class CursoServiceImpl implements CursoService {

    private final EstudianteRepository estudianteRepository;
	
	@Autowired
	private CursoRepository repo;

    CursoServiceImpl(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

	@Override
	public Curso crear(Curso c) {
		return null;
	}

	@Override
	public void añadirEstudiante(Curso c, Estudiante e) {
;		 c.getEstudiantes().add(e);
		 repo.save(c); 
	}

	@Override
	public List<Curso> obtenerCursos() {
		return repo.findAll();
	}

	@Override
	public Curso obtenerCurso(Integer id) {
		return repo.findById(id).orElse(null); 
	}

	@Override
	public List<Curso> obtenerCursosPalabra(String palabra) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarEstudiante(Estudiante e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarCurso(Integer id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		
	} 
	

}
