package com.ejercicios.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejercicios.modelo.Ingrediente;
import com.ejercicios.modelo.Muestrario;
import com.ejercicios.modelo.Receta;
import com.ejercicios.repository.MuestrarioRepository;
import com.ejercicios.repository.RecetaRepository;

import jakarta.transaction.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MuestrarioServiceImpl implements MuestrarioService {

    @Autowired
	MuestrarioRepository muestrarioRepository;
    
    @Autowired
    RecetaRepository recetaRepository;


    @Override
    public List<Muestrario> findAll() {
        return muestrarioRepository.findAll();
    }

    @Override
    public Optional<Muestrario> findById(Long id) {
        return muestrarioRepository.findById(id);
    }

    @Override
    public Muestrario save(Muestrario muestrario) {
        return muestrarioRepository.save(muestrario);
    }

    @Override
    public void deleteById(Long id) {
        muestrarioRepository.deleteById(id);
    }

    @Override
    public Muestrario addReceta(Long muestrarioId, Long recetaId) {
        Muestrario m = muestrarioRepository.findById(muestrarioId)
                .orElse(null);
        Receta r = recetaRepository.findById(recetaId)
                .orElse(null);
        if(m!=null && r!=null) {
	        m.getRecetas().add(r);
	        r.setMuestrario(m);
	
	        muestrarioRepository.save(m);
        }
        return null; 
    }

    @Override
    public Muestrario removeReceta(Long muestrarioId, Long recetaId) {
        Muestrario m = muestrarioRepository.findById(muestrarioId)
        		.orElse(null);
        Receta r = recetaRepository.findById(recetaId)
        		.orElse(null);
        m.getRecetas().remove(r);
        r.setMuestrario(null);

        return muestrarioRepository.save(m);
    }
    
    public String mostrarRecetasEIngredientes(Long muestrarioId) {

        Muestrario m = muestrarioRepository.findById(muestrarioId).orElse(null);

        if (m == null) {
            return "No se encontró el muestrario con ID: " + muestrarioId;
        }

        String resultado = "Muestrario: " + m.getNombre() + "\n\n";

        if (m.getRecetas() == null || m.getRecetas().isEmpty()) {
            resultado += "Este muestrario no tiene recetas.\n";
            return resultado;
        }

        for (Receta r : m.getRecetas()) {

            resultado += "  - Receta: " + r.getNombre()
                      + " (puntuación: " + r.getPuntuacion() + ")\n";

            if (r.getIngredientes() == null || r.getIngredientes().isEmpty()) {
                resultado += "       * No tiene ingredientes\n";
            } else {
                for (Ingrediente i : r.getIngredientes()) {
                    resultado += "       * " + i.getNombre()
                              + " — " + i.getCalorias() + " kcal\n";
                }
            }

            resultado += "\n";
        }

        return resultado;
    }

    @Override
    public Optional<Receta> findFirstRecetaAlphabetically(Long muestrarioId) {
        Muestrario m = muestrarioRepository.findById(muestrarioId)
                .orElseThrow(() -> new RuntimeException("Muestrario no encontrado"));

        return m.getRecetas().stream()
                .sorted(Comparator.comparing(Receta::getNombre))
                .findFirst();
    }
}
