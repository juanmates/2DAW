package com.ejercicios.servicio;

import java.util.List;

import com.ejercicios.modelo.Hotel;

public interface HotelService {

    List<Hotel> buscarPorEstrellas(int estrellas);

    List<Hotel> buscarRangoEstrellas(int min, int max);

    List<Hotel> tresMasEstrellas();

    List<Hotel> buscarNombreoDireccion(String texto);

    int contarPorEstrellas(int estrellas);

    List<Hotel> hotelesSinWeb();

    // Para insertar o actualizar hoteles (prueba en main)
    Hotel guardarHotel(Hotel hotel);

    //List<Hotel> listarTodos();
    
    List<Hotel> hotelesOrdenadosPorEstrellasYNombre();
}