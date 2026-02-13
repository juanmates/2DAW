package com.ejercicios.servicio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejercicios.modelo.Reserva;
import com.ejercicios.repositorio.ReservaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ReservaServiceImpl implements ReservaService{
	
	@Autowired
	private ReservaRepository repositorio;

	@Override
	public Reserva crearActualizarReserva(Reserva entidad) {
		// TODO Auto-generated method stub
		return repositorio.save(entidad);
	}

	@Override
	public List<Reserva> listarTodasLasReservar() {
		// TODO Auto-generated method stub
		return repositorio.findAll();
	}

	@Override
	public Reserva buscarReservaSegunId(Long id) {
		// TODO Auto-generated method stub
		return repositorio.findById(id).orElse(null);
	}

	@Override
	public void eliminarReservaSegunId(Long id) {
		// TODO Auto-generated method stub
		repositorio.deleteById(id);
	}

	@Override
	public List<Reserva> buscarPorUsuario(Long idUsuario) {
		// TODO Auto-generated method stub
		List<Reserva> todas = repositorio.findAll();
		List<Reserva> res = new ArrayList<>();
		for(Reserva r : todas) {
			if(r.getUsuario_reservas() != null &&
			r.getUsuario_reservas().getId().equals(idUsuario)) {
				res.add(r);
			}
		}
		return res;
	}

	@Override
	public List<Reserva> buscarPorFecha(LocalDate fecha) {
		// TODO Auto-generated method stub
		List<Reserva> todas = repositorio.findAll();
		return todas.stream().filter(r -> r.getFecha_reserva() != null && 
		r.getFecha_reserva().equals(fecha)).collect(Collectors.toList());
	}

	@Override
	public void cancelarLaReservaDeUsuario(Long idUsuario) {
		// TODO Auto-generated method stub
		List<Reserva> todas = repositorio.findAll();
		for(Reserva r: todas)  {
			if(r.getUsuario_reservas() != null && 
			r.getUsuario_reservas().getId().equals(idUsuario)) {
				repositorio.delete(r);
			}
		}
	}

}
