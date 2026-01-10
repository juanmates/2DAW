package com.ejercicios.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.ejercicios.modelo.Ingrediente;
import com.ejercicios.modelo.Receta;
import com.ejercicios.service.IngredienteService;
import com.ejercicios.service.RecetaService;

@Controller
@RequestMapping("/ingredientes")
public class IngredienteController {

    @Autowired
    IngredienteService ingredienteService;
    
    @Autowired
    RecetaService recetaService;

    @GetMapping("/inicio")
    public String index() {
        return "index";
    }
    
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("ingredientes", ingredienteService.findAll());
        return "ingredientes/list";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("ingrediente", new Ingrediente());
        return "ingredientes/form";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Ingrediente ingrediente) {
        ingredienteService.save(ingrediente);
        return "redirect:/ingredientes";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("ingrediente", ingredienteService.findById(id));
        return "ingredientes/form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        ingredienteService.deleteById(id);
        return "redirect:/ingredientes";
    }
    
    @GetMapping("/consultas/mejor-receta")
    public String mejorReceta(Model model) {
        Receta receta = recetaService.findTopByOrderByPuntuacionDesc().orElse(null);
        model.addAttribute("receta", receta);
        return "consultas/mejor-receta";
    }
}
