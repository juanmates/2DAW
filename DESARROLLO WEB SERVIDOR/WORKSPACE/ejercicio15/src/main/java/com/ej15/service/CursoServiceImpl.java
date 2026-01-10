package com.ej15.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ej15.model.Curso;
import com.ej15.model.Estudiante;
import com.ej15.repository.CursoRepository;
import com.ej15.repository.EstudianteRepository;

import jakarta.transaction.Transactional;

@Service
public class CursoServiceImpl implements CursoService{
	@Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Override
    public Curso crearCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Override
    public Curso agregarEstudiante(Integer cursoId, Integer estudianteId) {
        Optional<Curso> cursoOpt = cursoRepository.findById(cursoId);
        Optional<Estudiante> estOpt = estudianteRepository.findById(estudianteId);

        if (cursoOpt.isPresent() && estOpt.isPresent()) {
            Curso curso = cursoOpt.get();
            Estudiante estudiante = estOpt.get();

            curso.addEstudiante(estudiante);
            cursoRepository.save(curso);
            estudianteRepository.save(estudiante);
            return curso;
        } else {
            throw new RuntimeException("Curso o Estudiante no encontrado");
        }
    }

    @Override
    public Curso eliminarEstudiante(Integer cursoId, Integer estudianteId) {
        Optional<Curso> cursoOpt = cursoRepository.findById(cursoId);
        Optional<Estudiante> estOpt = estudianteRepository.findById(estudianteId);

        if (cursoOpt.isPresent() && estOpt.isPresent()) {
            Curso curso = cursoOpt.get();
            Estudiante estudiante = estOpt.get();

            curso.removeEstudiante(estudiante);
            cursoRepository.save(curso);
            estudianteRepository.save(estudiante);
            return curso;
        } 
        return null;
    }

    @Override
    public List<Curso> obtenerTodos() {
        return cursoRepository.findAll();
    }

    @Override
    public Curso obtenerPorId(Integer id) {
        Optional<Curso> curso = cursoRepository.findById(id);
        if (curso.isPresent()) {
            return curso.get();
        } 
        return null;
    }

    @Override
    public List<Curso> buscarPorNombre(String palabra) {
        return cursoRepository.findByNombreContainingIgnoreCase(palabra);
    }

    @Override
    public void eliminarCurso(Integer id) {
        if (cursoRepository.existsById(id)) {
            cursoRepository.deleteById(id);
        } 
        
    }
	
}
