package com.ej07.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ej07.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    List<Cliente> findByDireccionCiudad(String ciudad);
    
    List<Cliente> findByNombreStartingWithIgnoreCase(String letra);

   
}

