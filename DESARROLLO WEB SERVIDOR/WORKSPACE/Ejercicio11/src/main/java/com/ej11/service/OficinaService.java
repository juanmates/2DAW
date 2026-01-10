package com.ej11.service;

import java.util.List;
import java.util.Map;

import com.ej11.model.Oficina;

public interface OficinaService {
    Oficina crear(Oficina o);
    List<Oficina> listar();
    Oficina buscarPorId(Integer id);
    void eliminar(Integer id);
    Integer contarEmpleados(Integer oficinaId);
    Map<Integer, Integer> mapaOficinasConCantidad();
    List<Oficina> oficinasConMasDeN(int n);
    void actualizarTelefonoPorEmpleadoId(Integer empleadoId, String nuevoTelefono);
}