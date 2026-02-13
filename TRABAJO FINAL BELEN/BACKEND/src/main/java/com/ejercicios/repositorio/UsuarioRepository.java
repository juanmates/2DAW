package com.ejercicios.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejercicios.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	// Spring Data JPA creará la consulta SQL automáticamente
    Usuario findByEmail(String email);
}
