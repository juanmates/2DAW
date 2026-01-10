package com.ej08.service;

import java.util.List;
import java.util.Optional;

import com.ej08.model.Perfil;
import com.ej08.model.Usuario;

public interface UsuarioService {

	List<Usuario> obtenerTodos();

	Usuario obtenerPorId(Long id);

	Usuario insertar(Usuario usuario);

	Usuario actualizar(Usuario usuario);

	boolean eliminar(Long id);

	Usuario actualizarPerfil(Long idUsuario, Perfil nuevoPerfil);

	Perfil obtenerPerfil(Long idUsuario);

	Usuario actualizarEstadoADisponible(Long idUsuario);

	List<Usuario> buscarPorBio(String palabra);

	Optional<Usuario> obtenerPrimerDisponible();

	List<Usuario> obtenerNoDisponibles();

	void actualizarTodosADisponible();
}
