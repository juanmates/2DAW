package com.ejercicios.servicio;

import java.util.List;

import com.ejercicios.modelo.Usuario;

public interface UsuarioService {
	
	///////////////////////////////////////
	
	//				CRUD

	Usuario crearActualizarUsuario(Usuario entidad);
	
	List<Usuario> listarTodosLosUsuarios();
	
	Usuario buscarUsuarioPorId(Long id);
	
	void eliminarAutoescuelaSegunId(Long id);
	
	///////////////////////////////////////
	
	//Validar Login
	Boolean validarAcceso(String email, String password);
	
	// Buscar usuario por su correo electronico
	Usuario buscarPorEmail(String email);
	
	// Cambiar la contraseña de un usuario validando la anterior
	Boolean cambiarPassword(Long id, String antiguaPassword, String nuevaPassword);
	
	// Obtener el nombre completo (nombre + apellidos)
	String obtenerNombreCompleto(Long id);
	
}
