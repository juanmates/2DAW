package com.ej09.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ej09.model.Perfil;
import com.ej09.model.Usuario;

import jakarta.transaction.Transactional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	List<Usuario> findByPerfilBioContainingIgnoreCase(String palabra);

    Optional<Usuario> findFirstByPerfilEstado(String estado);

    List<Usuario> findByPerfilEstado(String estado);

    @Modifying
    @Transactional
    @Query("UPDATE Perfil p SET p.estado = 'DISPONIBLE'")
    void actualizarTodosLosEstadosADisponible();
	
}
