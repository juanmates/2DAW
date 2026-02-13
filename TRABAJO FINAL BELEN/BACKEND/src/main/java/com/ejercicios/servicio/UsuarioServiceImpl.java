package com.ejercicios.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ejercicios.modelo.Usuario;
import com.ejercicios.repositorio.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepository repositorio;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Override
    public Usuario crearActualizarUsuario(Usuario entidad) {
        // 2. Antes de guardar, ciframos la contraseña
        // Solo la ciframos si no está ya cifrada (para evitar cifrar un hash)
        if (entidad.getContrasenya() != null && !entidad.getContrasenya().startsWith("$2a$")) {
            String passCifrada = passwordEncoder.encode(entidad.getContrasenya());
            entidad.setContrasenya(passCifrada);
        }
        
        return repositorio.save(entidad);
    }

	@Override
	public List<Usuario> listarTodosLosUsuarios() {
		// TODO Auto-generated method stub
		return repositorio.findAll();
	}

	@Override
	public Usuario buscarUsuarioPorId(Long id) {
		// TODO Auto-generated method stub
		return repositorio.findById(id).orElse(null);
	}

	@Override
	public void eliminarAutoescuelaSegunId(Long id) {
		// TODO Auto-generated method stub
		repositorio.deleteById(id);
	}

	@Override
	public Usuario buscarPorEmail(String email) {
		// TODO Auto-generated method stub
		return repositorio.findAll().stream()
		.filter(u -> u.getEmail().equalsIgnoreCase(email))
		.findFirst().orElse(null);
	}

	@Override
	public Boolean cambiarPassword(Long id, String antiguaPassword, String nuevaPassword) {
		// TODO Auto-generated method stub
		Usuario u = buscarUsuarioPorId(id);
		if(u != null && u.getContrasenya().equals(antiguaPassword)) {
			u.setContrasenya(nuevaPassword);
			repositorio.save(u);
			return true;
		}
		return false;
	}

	@Override
	public String obtenerNombreCompleto(Long id) {
		// TODO Auto-generated method stub
		Usuario u = buscarUsuarioPorId(id);
		if(u == null) {
			return "Usuario no encontrado";
		}
		return u.getNombre().toUpperCase() + " " + u.getRol();
	}

}
