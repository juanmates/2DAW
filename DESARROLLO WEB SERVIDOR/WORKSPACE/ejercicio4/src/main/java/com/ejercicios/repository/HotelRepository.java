package com.ejercicios.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ejercicios.modelo.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long> {

    // Buscar hoteles con un número exacto de estrellas
    List<Hotel> findByEstrellas(int estrellas);

    // Buscar hoteles con estrellas entre rango (mín y máx)
    List<Hotel> findByEstrellasBetween(int min, int max);

    // Obtener los 3 hoteles con más estrellas (orden descendente por estrellas)
    List<Hotel> findTop3ByOrderByEstrellasDesc();

    // Buscar por nombre o dirección (contenga, case-insensitive)
    List<Hotel> findByNombreContainingIgnoreCaseOrDireccionContainingIgnoreCase(String nombre, String direccion);

    // Contar hoteles con un número exacto de estrellas
    int countByEstrellas(int estrellas);

    // Hoteles sin página web
    List<Hotel> findByPaginaWebIsNull();
    
    @Query("SELECT h FROM Hotel h ORDER BY h.estrellas DESC, h.nombre ASC")
    List<Hotel> hotelesOrdenadosPorEstrellasYNombre();
    
    //List<Hotel> findAllByOrderByEstrellasDescNombreAsc();
}