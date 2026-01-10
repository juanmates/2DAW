package com.ej09.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ej09.model.Perfil;
import com.ej09.model.Usuario;
import com.ej09.repository.UsuarioRepository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
    private UsuarioRepository usuarioRepo;

    @Override
    public List<Usuario> obtenerTodos() {
        return usuarioRepo.findAll();
    }

    @Override
    public Usuario obtenerPorId(Long id) {
        return usuarioRepo.findById(id).orElse(null);
    }

    @Override
    public Usuario insertar(Usuario usuario) {
        return usuarioRepo.save(usuario);
    }

    
    
    @Override
    public Usuario actualizar(Usuario usuario) {
    	 Optional<Usuario> existente = usuarioRepo.findById(usuario.getId());
    	    if (existente.isPresent()) {
    	        Usuario original = existente.get();
    	        original.setNombre(usuario.getNombre());
    	        original.setEmail(usuario.getEmail());
    	        original.setPerfil(usuario.getPerfil()); // opcional si quieres actualizar el perfil completo
    	        usuario.getPerfil().setUsu(original);
    	       
    	        return usuarioRepo.save(original);
    	    }
    	    return null;
    	   
    }

    @Override
    public boolean eliminar(Long id) {
        if (usuarioRepo.existsById(id)) {
            usuarioRepo.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Usuario actualizarPerfil(Long idUsuario, Perfil nuevoPerfil) {
        Usuario usuario = obtenerPorId(idUsuario);
        if (usuario != null) {
            usuario.setPerfil(nuevoPerfil);
            nuevoPerfil.setUsu(usuario);
            return usuarioRepo.save(usuario);
        }
        return null;
    }

    @Override
    public Perfil obtenerPerfil(Long idUsuario) {
        Usuario usuario = obtenerPorId(idUsuario);
        return usuario != null ? usuario.getPerfil() : null;
    }

    @Override
    public Usuario actualizarEstadoADisponible(Long idUsuario) {
        Usuario usuario = obtenerPorId(idUsuario);
        if (usuario != null && usuario.getPerfil() != null) {
            usuario.getPerfil().setEstado("DISPONIBLE");
            return usuarioRepo.save(usuario);
        }
        return null;
    }

    @Override
    public List<Usuario> buscarPorBio(String palabra) {
        return usuarioRepo.findByPerfilBioContainingIgnoreCase(palabra);
    }

    @Override
    public Optional<Usuario> obtenerPrimerDisponible() {
        return usuarioRepo.findFirstByPerfilEstado("DISPONIBLE");
    }

    @Override
    public List<Usuario> obtenerNoDisponibles() {
        return usuarioRepo.findByPerfilEstado("NO DISPONIBLE");
    }

    @Override
    public void actualizarTodosADisponible() {
       // usuarioRepo.actualizarTodosLosEstadosADisponible();
    	
    
    	    List<Usuario> usuarios = usuarioRepo.findAll();

    	    for (Usuario usuario : usuarios) {
    	        if (usuario.getPerfil() != null) {
    	            usuario.getPerfil().setEstado("DISPONIBLE");
    	        }
    	    }

    	    usuarioRepo.saveAll(usuarios); // Gracias al cascade se guardan también los perfiles
    	
    }

}
