package com.ejercicios.servicio;

import java.util.List;

import com.ejercicios.modelo.Usuario;

public interface UsuarioService {

	Usuario crearActualizarUsuario(Usuario entidad);
	
	List<Usuario> listarTodosLosUsuarios();
	
	Usuario buscarUsuarioPorId(Long id);
	
	void eliminarAutoescuelaSegunId(Long id);
	
}
