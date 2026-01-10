package com.ej06.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ej06.model.Cliente;
import com.ej06.model.Direccion;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    List<Cliente> findByDireccionCiudad(String ciudad);
    
    List<Cliente> findByNombreStartingWithIgnoreCase(String letra);

    @Modifying
     @Query("UPDATE Direccion d SET d.ciudad = 'Sevilla' WHERE d IN (" +
    	       "SELECT c.direccion FROM Cliente c WHERE LOWER(c.nombre) LIKE 'a%')")
    int actualizarCiudadPorNombreInicial(String letra, String ciudad);
}


