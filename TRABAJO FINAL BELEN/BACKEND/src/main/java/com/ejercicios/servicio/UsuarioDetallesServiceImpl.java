package com.ejercicios.servicio;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ejercicios.modelo.Usuario;
import com.ejercicios.repositorio.UsuarioRepository;

@Service
public class UsuarioDetallesServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository repositorio;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // 1. Buscamos en la base de datos por el campo que uses para loguear (email)
        Usuario usuario = repositorio.findByEmail(email);
        
        // 2. Si no existe, lanzamos la excepción que Spring Security espera
        if (usuario == null) {
            throw new UsernameNotFoundException("No se encontró el usuario con email: " + email);
        }

        // 3. Convertimos TU clase Usuario a la clase User de Spring Security
        // De momento le asignamos un rol genérico "ROLE_USER"
        return new User(
                usuario.getEmail(), 
                usuario.getContrasenya(), // Esta password debe estar cifrada en BD
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"))
        );
    }
}
