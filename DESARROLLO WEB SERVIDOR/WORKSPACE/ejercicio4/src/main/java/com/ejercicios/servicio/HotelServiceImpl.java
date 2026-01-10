package com.ejercicios.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejercicios.modelo.Hotel;
import com.ejercicios.repository.HotelRepository;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
	HotelRepository hotelRepository;


    @Override
    public List<Hotel> buscarPorEstrellas(int estrellas) {
        return hotelRepository.findByEstrellas(estrellas);
    }

    @Override
    public List<Hotel> buscarRangoEstrellas(int min, int max) {
        return hotelRepository.findByEstrellasBetween(min, max);
    }

    @Override
    public List<Hotel> tresMasEstrellas() {
        return hotelRepository.findTop3ByOrderByEstrellasDesc();
    }

    @Override
    public List<Hotel> buscarNombreoDireccion(String texto) {
        return hotelRepository.findByNombreContainingIgnoreCaseOrDireccionContainingIgnoreCase(texto, texto);
    }

    @Override
    public int contarPorEstrellas(int estrellas) {
        return hotelRepository.countByEstrellas(estrellas);
    }

    @Override
    public List<Hotel> hotelesSinWeb() {
        return hotelRepository.findByPaginaWebIsNull();
    }

    @Override
    public Hotel guardarHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> hotelesOrdenadosPorEstrellasYNombre() {
        return hotelRepository.hotelesOrdenadosPorEstrellasYNombre();
    }
	
}
