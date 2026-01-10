package com.ej08.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ej08.model.Usuario;
import com.ej08.service.UsuarioService;



@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping
    public String principal(Model model) {
        return "index";
    }

	@GetMapping("/todos")
    public String listarUsuarios(Model model) {
        model.addAttribute("usuarios", usuarioService.obtenerTodos());
        return "usuarios";
    }
    @GetMapping("/nuevo")
    public String nuevoUsuario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuario-form";
    }

    @GetMapping("/primerDisponible")
    public String primero(Model model) {
        model.addAttribute("usuario", usuarioService.obtenerPrimerDisponible().orElse(null));
        return "primerUsuario";
    }
    
    @PostMapping("/todos")
    public String guardarUsuario(@ModelAttribute Usuario usuario) {
        usuarioService.insertar(usuario);
        return "redirect:/usuarios/todos";
    }

    @GetMapping("/editar/{id}")
    public String editarUsuario(@PathVariable Long id, Model model) {
        Usuario usuario = usuarioService.obtenerPorId(id);
        model.addAttribute("usuario", usuario);
        return "usuario-form";
    }

 /*   @PostMapping("/editar")
    public String actualizarUsuario(Usuario usuario) {
        usuarioService.actualizar(usuario);
        return "redirect:/usuarios";
    }

    @PostMapping("/{id}")
    public String eliminarUsuario(@PathVariable Long id) {
        usuarioService.eliminar(id);
        return "redirect:/usuarios";
    }*/

}
